package com.ccufs.quote_application.repository;

import com.ccufs.quote_application.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Quote findQuoteById(Long id);
}