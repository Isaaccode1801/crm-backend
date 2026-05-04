package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, UUID> {
    java.util.List<NotaFiscal> findByLeadId(UUID leadId);
}
