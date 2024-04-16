package com.ccufs.quote_application.repository;

import com.ccufs.quote_application.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);

   @Query("SELECT a FROM Author a WHERE a.faculty = :faculty")
   List<Author> findAuthorByFaculty(@Param("faculty") String faculty);
}
