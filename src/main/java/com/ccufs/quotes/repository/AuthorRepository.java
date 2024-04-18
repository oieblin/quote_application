package com.ccufs.quotes.repository;

import com.ccufs.quotes.model.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface Author repository.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
  /**
   * Find author by id author.
   *
   * @param id the id
   * @return the author
   */
  Author findAuthorById(Long id);

  /**
   * Find author by faculty list.
   *
   * @param faculty the faculty
   * @return the list
   */
  @Query("SELECT a FROM Author a WHERE a.faculty = :faculty")
  List<Author> findAuthorByFaculty(@Param("faculty") String faculty);
}
