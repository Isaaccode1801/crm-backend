package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.Lead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.EntityGraph;
import java.util.List;
import java.util.UUID;

@Repository
public interface LeadRepository extends JpaRepository<Lead, UUID> {
    @EntityGraph(attributePaths = {"notasFiscais", "historico"})
    List<Lead> findAll();

    @EntityGraph(attributePaths = {"notasFiscais", "historico"})
    java.util.Optional<Lead> findById(UUID id);

    @Query("SELECT l FROM Lead l WHERE " +
           "((:search IS NULL OR :search = '' OR LOWER(l.nome) LIKE LOWER(CONCAT('%', :search, '%'))) OR " +
           "(:search IS NULL OR :search = '' OR LOWER(l.email) LIKE LOWER(CONCAT('%', :search, '%'))) OR " +
           "(:search IS NULL OR :search = '' OR LOWER(l.telefone) LIKE LOWER(CONCAT('%', :search, '%')))) AND " +
           "(:stage IS NULL OR :stage = 'all' OR l.statusFunil = :stage)")
    Page<Lead> findBySearch(@Param("search") String search, @Param("stage") String stage, Pageable pageable);
}
