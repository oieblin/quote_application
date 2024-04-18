package com.ccufs.quotes.repository;

import com.ccufs.quotes.model.Quote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface Quote repository.
 */
public interface QuoteRepository extends JpaRepository<Quote, Long> {
  /**
     * Find quote by id quote.
     *
     * @param id the id
     * @return the quote
     */
  Quote findQuoteById(Long id);
  /**
     * Find quotes by surname list.
     *
     * @param surname the surname
     * @return the list
     */

  @Query("SELECT q FROM Quote q WHERE q.author.surname = :surname")
  List<Quote> findQuotesBySurname(@Param("surname") String surname);
}