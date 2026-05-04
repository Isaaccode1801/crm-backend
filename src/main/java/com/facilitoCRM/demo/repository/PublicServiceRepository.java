package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.PublicService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PublicServiceRepository extends JpaRepository<PublicService, UUID> {
}
