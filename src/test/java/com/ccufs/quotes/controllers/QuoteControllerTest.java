package com.ccufs.quotes.controllers;

import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.QuoteRepository;
import com.ccufs.quotes.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class QuoteControllerTest {

  @Mock
  QuoteRepository quoteRepository;

  @InjectMocks
  QuoteService quoteService;

  @Test
  void testSaveQuote() {
    Quote quote = new Quote();
    quote.setId(1L);
    quote.setText("Test quote");

    when(quoteRepository.save(quote)).thenReturn(quote);

    Quote savedQuote = quoteService.saveQuote(quote);

    assertEquals(quote, savedQuote);
    verify(quoteRepository).save(quote);
  }

  @Test
  void testFindAllQuotes() {
    Long quoteId1 = 1L;
    Quote quote1 = new Quote();
    quote1.setId(quoteId1);

    Long quoteId2 = 2L;
    Quote quote2 = new Quote();
    quote2.setId(quoteId2);

    List<Quote> quotes = Arrays.asList(quote1, quote2);
    when(quoteRepository.findAll()).thenReturn(quotes);

    List<Quote> savedQuotes = quoteService.findAllQuotes();
    assertEquals(quotes, savedQuotes);
    verify(quoteRepository).findAll();
  }
}
