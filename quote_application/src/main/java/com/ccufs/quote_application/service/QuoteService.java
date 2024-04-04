package com.ccufs.quote_application.service;

import com.ccufs.quote_application.model.Author;
import com.ccufs.quote_application.model.Quote;
import com.ccufs.quote_application.repository.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;
    public Quote saveQuote(Quote quote){
        return quoteRepository.save(quote);
    }
    public List<Quote> findAllQuotes(){
        return quoteRepository.findAll();
    }
    public Quote findQuoteById(Long id){
        return quoteRepository.findQuoteById(id);
    }
    public Quote updateQuote(Quote quote){
        return quoteRepository.save(quote);
    }

    public void deleteQuoteById(Long id){
        Quote quote = quoteRepository.findQuoteById(id);
        if (quote != null) {
            quote.setAuthor(null);
            quoteRepository.delete(quote);
        }
    }
}
