package com.ccufs.quotes.service;

import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.QuoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuoteServiceTest {

  @Mock
  private QuoteRepository quoteRepository;

  @InjectMocks
  private QuoteService quoteService;

  @Test
  void testFindQuoteById() {
    Long quoteId = 1L;
    Quote quote = new Quote();
    quote.setId(quoteId);
    quote.setText("Test quote");

    when(quoteRepository.findQuoteById(quoteId)).thenReturn(quote);

    Quote foundQuote = quoteService.findQuoteById(quoteId);

    assertEquals(quote, foundQuote);
    verify(quoteRepository).findQuoteById(quoteId);

  }

  @Test
  void testDeleteQuoteById() {
    Long quoteId = 1L;
    Quote quote = new Quote();
    quote.setId(quoteId);
    quote.setText("Test quote");

    when(quoteRepository.findQuoteById(quoteId)).thenReturn(quote);

    quoteService.deleteQuoteById(quoteId);

    verify(quoteRepository).findQuoteById(quoteId);
    verify(quoteRepository).delete(quote);
  }

  @Test
  void testBulkSaveQuotes() {
    Long quoteId1 = 1L;
    Quote quote1 = new Quote();
    quote1.setId(quoteId1);

    Long quoteId2 = 2L;
    Quote quote2 = new Quote();
    quote2.setId(quoteId2);

    List<Quote> quotes = Arrays.asList(quote1, quote2);

    when(quoteRepository.save(any(Quote.class))).thenAnswer(invocation -> invocation.getArgument(0));

    List<Quote> savedQuotes = quoteService.bulkSaveQuotes(quotes);

    assertEquals(quotes, savedQuotes);
    verify(quoteRepository, times(2)).save(any(Quote.class));
  }

  @Test
  void TestSaveQuote() {
    Long quoteId = 1L;
    Quote quote = new Quote();
    quote.setId(quoteId);
    quote.setText("Test quote");
    when(quoteRepository.save(any(Quote.class))).thenAnswer(invocation -> invocation.getArgument(0));
    Quote savedQuote = quoteService.saveQuote(quote);
    assertEquals(quote, savedQuote);
    verify(quoteRepository).save(any(Quote.class));
  }
}

