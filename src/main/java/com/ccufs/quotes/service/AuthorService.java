package com.ccufs.quotes.service;

import com.ccufs.quotes.model.Author;
import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.AuthorRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Author service.
 */
@Service
@AllArgsConstructor
public class AuthorService {
  private final AuthorRepository authorRepository;
  private final QuoteService quoteService;

  /**
   * Save author author.
   *
   * @param author the author
   * @return the author
   */
  public Author saveAuthor(Author author) {

    return authorRepository.save(author);
  }

  /**
   * Find all authors list.
   *
   * @return the list
   */
  public List<Author> findAllAuthors() {

    return authorRepository.findAll();
  }

  /**
   * Gets author by id.
   *
   * @param id the id
   * @return the author by id
   */
  public Author getAuthorById(Long id) {

    return authorRepository.findAuthorById(id);
  }

  /**
   * Update author author.
   *
   * @param author the author
   * @return the author
   */
  public Author updateAuthor(Author author) {

    return authorRepository.save(author);
  }

  /**
   * Add quote by id quote.
   *
   * @param authorId the author id
   * @param quoteId  the quote id
   * @return the quote
   */
  public Quote addQuoteById(Long authorId, Long quoteId) {
    Quote quote = quoteService.findQuoteById(quoteId);
    if (quote != null) {
      Author author = authorRepository.findAuthorById(authorId);
      if (author != null) {
        author.getQuotes().add(quote);
        quote.setAuthor(author);
        quoteService.saveQuote(quote);
        authorRepository.save(author);
        return quote;
      } else {
        return quote;
      }
    }
    return null;
  }

  /**
   * Remove quote by id.
   *
   * @param authorId the author id
   * @param quoteId  the quote id
   */
  public void removeQuoteById(Long authorId, Long quoteId) {
    Quote quote = quoteService.findQuoteById(quoteId);
    if (quote != null) {
      Author author = authorRepository.findAuthorById(authorId);
      if (author != null) {
        author.getQuotes().remove(quote);
        quote.setAuthor(null);
        quoteService.saveQuote(quote);
        authorRepository.save(author);
      }
    }


  }

  /**
   * Delete author by id.
   *
   * @param id the id
   */
  public void deleteAuthorById(Long id) {
    Author author = authorRepository.findAuthorById(id);
    if (author != null) {
      List<Quote> quotes = author.getQuotes().stream().toList();
      for (Quote quote : quotes) {
        quote.setAuthor(null);
        quoteService.saveQuote(quote);
      }
      authorRepository.delete(author);
    }
  }

  /**
   * Find authors by faculty list.
   *
   * @param faculty the faculty
   * @return the list
   */
  public List<Author> findAuthorsByFaculty(String faculty) {

    return authorRepository.findAuthorByFaculty(faculty);
  }

  /**
   * Bulk save authors list.
   *
   * @param authors the authors
   * @return the list
   */
  public List<Author> bulkSaveAuthors(List<Author> authors) {
    return authors.stream()
            .map(authorRepository::save)
            .collect(Collectors.toList());
  }
}

