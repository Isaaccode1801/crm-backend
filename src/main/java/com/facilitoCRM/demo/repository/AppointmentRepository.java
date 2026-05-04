package com.facilitoCRM.demo.repository;

import com.facilitoCRM.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    java.util.List<Appointment> findByLeadId(UUID leadId);
}
