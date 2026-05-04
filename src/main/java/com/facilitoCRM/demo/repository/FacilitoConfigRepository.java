package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.FacilitoConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface FacilitoConfigRepository extends JpaRepository<FacilitoConfig, UUID> {
}
