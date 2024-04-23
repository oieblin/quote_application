package com.ccufs.quotes.controllers;

import com.ccufs.quotes.model.Author;
import com.ccufs.quotes.model.Quote;
import com.ccufs.quotes.repository.AuthorRepository;
import com.ccufs.quotes.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {
  @Mock
  private AuthorRepository authorRepository;

  @InjectMocks
  private AuthorService authorService;

  @Test
  void testPostAuthor() {
    Author author = new Author();
    author.setId(1L);
    author.setSurname("Doe");
    author.setName("John");
    author.setPatronymic("James");
    author.setFaculty("Faculty1");

    when(authorRepository.save(author)).thenReturn(author);

    Author updatedAuthor = authorService.saveAuthor(author);

    assertEquals(author, updatedAuthor);
    verify(authorRepository).save(author);
  }

  @Test
  void tetsGetAllAuthors() {
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

    List<Author> savedAuthors = authorService.findAllAuthors();
    assertEquals(authors, savedAuthors);
    verify(authorRepository).findAll();
  }

  @Test
  void testAddAuthor() {
    Author author = new Author();
    author.setId(1L);
    author.setSurname("Doe");
    author.setName("John");
    author.setPatronymic("James");
    author.setFaculty("Faculty1");

    when(authorRepository.save(author)).thenReturn(author);

    Author updatedAuthor = authorService.saveAuthor(author);

    assertEquals(author, updatedAuthor);
    verify(authorRepository).save(author);
  }
}
