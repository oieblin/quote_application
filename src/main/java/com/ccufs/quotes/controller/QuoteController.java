package com.ccufs.quotes.controller;


import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.QuoteRepository;
import com.ccufs.quotes.service.QuoteService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Quote controller.
 */
@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {
  private final QuoteService quoteService;
  private final QuoteRepository quoteRepository;

  /**
   * Instantiates a new Quote controller.
   *
   * @param quoteService    the quote service
   * @param quoteRepository the quote repository
   */
  public QuoteController(QuoteService quoteService, QuoteRepository quoteRepository) {
    this.quoteService = quoteService;
    this.quoteRepository = quoteRepository;
  }

  /**
   * Find quote by surname list.
   *
   * @param surname the surname
   * @return the list
   */
  @GetMapping("/surname/{surname}")
  public List<Quote> findQuoteBySurname(@PathVariable String surname) {
    return quoteRepository.findQuotesBySurname(surname);
  }

  /**
   * Post quote quote.
   *
   * @param quote the quote
   * @return the quote
   */
  @PostMapping
  public Quote postQuote(@RequestBody Quote quote) {

    return quoteService.saveQuote(quote);
  }

  /**
   * Get all quotes list.
   *
   * @return the list
   */
  @GetMapping
  public List<Quote> getAllQuotes() {
    return quoteService.findAllQuotes();
  }

  /**
   * Get quote by id quote.
   *
   * @param id the id
   * @return the quote
   */
  @GetMapping("{id}")
  public Quote getQuoteById(@PathVariable Long id) {
    return quoteService.findQuoteById(id);
  }

  /**
   * Update quote quote.
   *
   * @param quote the quote
   * @return the quote
   */
  @PutMapping
  public Quote updateQuote(@RequestBody Quote quote) {
    return quoteService.updateQuote(quote);
  }

  /**
   * Delete quote.
   *
   * @param id the id
   */
  @DeleteMapping("{id}")
  public void deleteQuote(@PathVariable Long id) {
    quoteService.deleteQuoteById(id);
  }

  @PostMapping("/bulk")
  public List<Quote> bulkSaveQuotes(@RequestBody List<Quote> quotes) {
    return quoteService.bulkSaveQuotes(quotes);
  }
}