package com.ccufs.quote_application.repository;

import com.ccufs.quote_application.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Quote findQuoteById(Long id);

    @Query("SELECT q FROM Quote q WHERE q.author.surname = :surname")
    List<Quote> findQuotesBySurname(@Param("surname") String surname);
}