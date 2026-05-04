package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {

    @EntityGraph(attributePaths = {"user", "services"})
    List<Provider> findAll();

    @EntityGraph(attributePaths = {"user", "services"})
    Optional<Provider> findById(UUID id);
}
