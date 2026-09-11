package com.pulsequeue.persistence;

import com.pulsequeue.domain.Job;

import java.util.Optional;
import java.util.UUID;

public interface JobRepository {

    Job save(Job job);

    Optional<Job> findById(UUID id);
}

