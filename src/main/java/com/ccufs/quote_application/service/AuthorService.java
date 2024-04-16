package com.ccufs.quote_application.service;

import com.ccufs.quote_application.model.Author;
import com.ccufs.quote_application.model.Quote;
import com.ccufs.quote_application.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final QuoteService quoteService;
    public Author saveAuthor(Author author){

        return authorRepository.save(author);
    }
    public List<Author> findAllAuthors(){

        return authorRepository.findAll();
    }
    public Author getAuthorById(Long id) {

        return authorRepository.findAuthorById(id);
    }
    public Author updateAuthor(Author author){

        return authorRepository.save(author);
    }
    public Quote addQuoteById(Long authorId, Long quoteId){
        Quote quote = quoteService.findQuoteById(quoteId);
        if(quote != null){
            Author author = authorRepository.findAuthorById(authorId);
            if(author != null){
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
    public void removeQuoteById(Long authorId, Long quoteId){
        Quote quote = quoteService.findQuoteById(quoteId);
        if (quote != null){
            Author author = authorRepository.findAuthorById(authorId);
            if (author != null){
                author.getQuotes().remove(quote);
                quote.setAuthor(null);
                quoteService.saveQuote(quote);
                authorRepository.save(author);
            }
        }
    }
    public void deleteAuthorById(Long id){
        Author author = authorRepository.findAuthorById(id);
        if (author != null) {
            List<Quote> quotes= author.getQuotes().stream().toList();
            for (Quote quote: quotes){
                quote.setAuthor(null);
                quoteService.saveQuote(quote);
            }
            authorRepository.delete(author);
        }
    }

    public List<Author> findAuthorsByFaculty(String faculty) {

        return authorRepository.findAuthorByFaculty(faculty);
        }
    }
