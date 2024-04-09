package com.ccufs.quote_application.controller;

import com.ccufs.quote_application.model.Quote;
import com.ccufs.quote_application.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public Quote postQuote(@RequestBody Quote quote){
        return quoteService.saveQuote(quote);
    }

    @GetMapping
    public List<Quote> getAllQuotes(){
        return quoteService.findAllQuotes();
    }

    @GetMapping("{id}")
    public Quote getQuoteById(@PathVariable Long id){
        return quoteService.findQuoteById(id);
    }

    @PutMapping
    public Quote updateQuote(@RequestBody Quote quote){
        return quoteService.updateQuote(quote);
    }



    @DeleteMapping("{id}")
    public void deleteQuote(@PathVariable Long id){
        quoteService.deleteQuoteById(id);
    }
}