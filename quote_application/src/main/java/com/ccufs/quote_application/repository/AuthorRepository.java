package com.ccufs.quote_application.repository;

import com.ccufs.quote_application.model.Author;
import com.ccufs.quote_application.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);
}
