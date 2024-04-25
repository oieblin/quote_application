package com.ccufs.quotes.service;

import com.ccufs.quotes.model.Author;
import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.AuthorRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

@Mock
private AuthorRepository authorRepository;

@Getter
@Setter
@Mock
private QuoteService quoteService;

@InjectMocks
private AuthorService authorService;


  @Test
  void testSaveAuthor() {
    Author author = new Author();
    author.setId(1L);
    author.setSurname("Doe");
    author.setName("John");
    author.setPatronymic("James");
    author.setFaculty("Faculty1");

    when(authorRepository.save(author)).thenReturn(author);

    Author savedAuthor = authorService.saveAuthor(author);

    assertEquals(author, savedAuthor);
    verify(authorRepository).save(author);
  }


  @Test
  void testFindAllAuthors() {
    Author author1 = new Author();
    author1.setId(1L);
    author1.setSurname("Doe");
    author1.setName("John");
    author1.setPatronymic("James");
    author1.setFaculty("Faculty1");

    Author author2 = new Author();
    author2.setId(2L);
    author2.setSurname("Smith");
    author2.setName("Jane");
    author2.setPatronymic("Alice");
    author2.setFaculty("Faculty2");

    List<Author> authors = Arrays.asList(author1, author2);

    when(authorRepository.findAll()).thenReturn(authors);

    List<Author> allAuthors = authorService.findAllAuthors();

    assertEquals(authors, allAuthors);
    verify(authorRepository).findAll();
  }

  @Test
  void testGetAuthorById() {
    Author author = new Author();
    author.setId(1L);
    author.setSurname("Doe");
    author.setName("John");
    author.setPatronymic("James");
    author.setFaculty("Faculty1");

    when(authorRepository.findAuthorById(1L)).thenReturn(author);

    Author foundAuthor = authorService.getAuthorById(1L);

    assertEquals(author, foundAuthor);
    verify(authorRepository).findAuthorById(1L);
  }

  @Test
  void testUpdateAuthor() {
    Author author = new Author();
    author.setId(1L);
    author.setSurname("Doe");
    author.setName("John");
    author.setPatronymic("James");
    author.setFaculty("Faculty1");

    when(authorRepository.save(author)).thenReturn(author);

    Author updatedAuthor = authorService.updateAuthor(author);

    assertEquals(author, updatedAuthor);
    verify(authorRepository).save(author);
  }

  @Test
  void testFindAuthorsByFaculty() {
    Author author1 = new Author();
    author1.setId(1L);
    author1.setSurname("Doe");
    author1.setName("John");
    author1.setPatronymic("James");
    author1.setFaculty("Faculty1");

    Author author2 = new Author();
    author2.setId(2L);
    author2.setSurname("Smith");
    author2.setName("Jane");
    author2.setPatronymic("Alice");
    author2.setFaculty("Faculty1");

    List<Author> authors = Arrays.asList(author1, author2);

    when(authorRepository.findAuthorByFaculty("Faculty 1")).thenReturn(authors);

    List<Author> foundAuthors = authorService.findAuthorsByFaculty("Faculty 1");

    assertEquals(authors, foundAuthors);
  }

  @Test
  void testBulkSaveAuthors() {

    Author author1 = new Author();
    author1.setId(1L);
    author1.setSurname("Doe");
    author1.setName("John");
    author1.setPatronymic("James");
    author1.setFaculty("Faculty1");

    Author author2 = new Author();
    author2.setId(2L);
    author2.setSurname("Smith");
    author2.setName("Jane");
    author2.setPatronymic("Alice");
    author2.setFaculty("Faculty1");

    List<Author> authors = Arrays.asList(author1, author2);

    when(authorRepository.save(any(Author.class))).thenAnswer(invocation -> invocation.getArgument(0));

    List<Author> savedAuthors = authorService.bulkSaveAuthors(authors);

    assertEquals(authors, savedAuthors);
    verify(authorRepository, times(2)).save(any(Author.class));
  }
}
