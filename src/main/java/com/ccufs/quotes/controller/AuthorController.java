package com.ccufs.quotes.controller;

import com.ccufs.quotes.model.Author;
import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.AuthorRepository;
import com.ccufs.quotes.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Author controller.
 */
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
  private final AuthorService authorService;
  private final AuthorRepository authorRepository;

  /**
   * Instantiates a new Author controller.
   *
   * @param authorService    the author service
   * @param authorRepository the author repository
   */
  @Autowired
  public AuthorController(AuthorService authorService, AuthorRepository authorRepository) {
    this.authorService = authorService;
    this.authorRepository = authorRepository;
  }

  /**
   * Post author author.
   *
   * @param author the author
   * @return the author
   */
  @PostMapping
  public Author postAuthor(@RequestBody Author author) {
    return authorService.saveAuthor(author);
  }

  /**
   * Get all authors list.
   *
   * @return the list
   */
  @GetMapping
  public List<Author> getAllAuthors() {
    return authorService.findAllAuthors();
  }

  /**
   * Get author by id author.
   *
   * @param id the id
   * @return the author
   */
  @GetMapping("{id}")
  public Author getAuthorById(@PathVariable Long id) {
    return authorService.getAuthorById(id);
  }


  /**
   * Find authors by faculty list.
   *
   * @param faculty the faculty
   * @return the list
   */
  @GetMapping("/faculty/{faculty}")
  public List<Author> findAuthorsByFaculty(@PathVariable String faculty) {
    int x = 1/0;
    return authorRepository.findAuthorByFaculty(faculty);
  }

  /**
   * Update author author.
   *
   * @param author the author
   * @return the author
   */
  @PutMapping
  public Author updateAuthor(@RequestBody Author author) {
    return authorService.updateAuthor(author);
  }

  /**
   * Add author quote.
   *
   * @param authorId the author id
   * @param quoteId  the quote id
   * @return the quote
   */
  @PutMapping("add-quote/{authorId}")
  public Quote addAuthor(@PathVariable Long authorId, @RequestParam Long quoteId) {
    return authorService.addQuoteById(authorId, quoteId);
  }

  /**
   * Remove quote by id.
   *
   * @param authorId the author id
   * @param quoteId  the quote id
   */
  @PutMapping("remove-quote/{authorId}")
  public void removeQuoteById(@PathVariable Long authorId, @RequestParam Long quoteId) {
    authorService.removeQuoteById(authorId, quoteId);
  }

  /**
   * Delete author.
   *
   * @param id the id
   */
  @DeleteMapping("{id}")
  public void deleteAuthor(@PathVariable Long id) {
    authorService.deleteAuthorById(id);
  }

  @PostMapping("/bulk")
  public List<Author> bulkSaveAuthors(@RequestBody List<Author> authors) {
    return authorService.bulkSaveAuthors(authors);
  }
}
