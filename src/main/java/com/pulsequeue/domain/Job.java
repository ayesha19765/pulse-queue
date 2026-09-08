package com.pulsequeue.domain;

import java.time.Instant;
import java.util.UUID;

public class Job {

    private UUID id;
    private String name;
    private JobPriority priority;
    private JobStatus status;
    private Instant createdAt;

    public Job(String name, JobPriority priority) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.priority = priority;
        this.status = JobStatus.QUEUED;
        this.createdAt = Instant.now();
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
