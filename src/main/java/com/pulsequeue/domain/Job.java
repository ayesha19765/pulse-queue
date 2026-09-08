package com.pulsequeue.domain;

import java.time.Instant;
import java.util.UUID;

public class Job {

    private UUID id;
    private String name;
    private JobStatus status;
    private Instant createdAt;

    public Job(UUID id, String name, JobStatus status, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JobStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}

