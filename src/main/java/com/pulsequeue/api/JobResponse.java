package com.pulsequeue.api;

import com.pulsequeue.domain.JobPriority;
import com.pulsequeue.domain.JobStatus;

import java.time.Instant;
import java.util.UUID;

public class JobResponse {

    private UUID id;
    private String name;
    private JobPriority priority;
    private JobStatus status;
    private Instant createdAt;

    public JobResponse(UUID id, String name, JobPriority priority, JobStatus status, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JobPriority getPriority() {
        return priority;
    }

    public JobStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}

