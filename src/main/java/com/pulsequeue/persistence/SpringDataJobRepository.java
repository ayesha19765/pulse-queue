package com.pulsequeue.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJobRepository extends JpaRepository<JobEntity, UUID> {
}

