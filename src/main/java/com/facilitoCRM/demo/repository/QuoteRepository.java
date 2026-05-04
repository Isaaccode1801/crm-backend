package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {
    java.util.List<Quote> findByLeadId(UUID leadId);
}
