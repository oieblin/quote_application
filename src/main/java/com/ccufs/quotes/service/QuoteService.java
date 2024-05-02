package com.ccufs.quotes.service;

import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.QuoteRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Quote service.
 */
@Service
@AllArgsConstructor
public class QuoteService {
  private final QuoteRepository quoteRepository;

  /**
   * Save quote quote.
   *
   * @param quote the quote
   * @return the quote
   */
  public Quote saveQuote(Quote quote) {

    return quoteRepository.save(quote);
  }

  /**
   * Find all quotes list.
   *
   * @return the list
   */
  public List<Quote> findAllQuotes() {

    return quoteRepository.findAll();
  }

  /**
   * Find quote by id quote.
   *
   * @param id the id
   * @return the quote
   */
  public Quote findQuoteById(Long id) {

    return quoteRepository.findQuoteById(id);
  }

  /**
   * Update quote quote.
   *
   * @param quote the quote
   * @return the quote
   */
  public Quote updateQuote(Quote quote) {

    return quoteRepository.save(quote);
  }

  /**
   * Delete quote by id.
   *
   * @param id the id
   */
  public void deleteQuoteById(Long id) {
    Quote quote = quoteRepository.findQuoteById(id);
    if (quote != null) {
      quote.setAuthor(null);
      quoteRepository.delete(quote);
    }
  }

  /**
   * Bulk save quotes list.
   *
   * @param quotes the quotes
   * @return the list
   */
  public List<Quote> bulkSaveQuotes(List<Quote> quotes) {
    return quotes.stream()
            .map(quoteRepository::save)
            .collect(Collectors.toList());
  }
}
