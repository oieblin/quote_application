package com.ccufs.quote_application.controller;

import com.ccufs.quote_application.model.Author;
import com.ccufs.quote_application.model.Quote;
import com.ccufs.quote_application.repository.AuthorRepository;
import com.ccufs.quote_application.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public Author postAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping("{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }


    @GetMapping("/faculty/{faculty}")
    public List<Author> findAuthorsByFaculty(@PathVariable String faculty) {
        return authorRepository.findAuthorByFaculty(faculty);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody Author author){
        return authorService.updateAuthor(author);
    }

    @PutMapping("add-quote/{authorId}")
    public Quote addAuthor(@PathVariable Long authorId, @RequestParam Long quoteId){
        return authorService.addQuoteById(authorId, quoteId);
    }

    @PutMapping("remove-quote/{authorId}")
    public void removeQuoteById(@PathVariable Long authorId, @RequestParam Long quoteId) {
        authorService.removeQuoteById(authorId, quoteId);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthorById(id);
    }

}
