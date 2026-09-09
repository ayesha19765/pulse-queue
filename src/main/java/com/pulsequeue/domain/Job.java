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

    public void transitionTo(JobStatus newStatus) {
        if (this.status == JobStatus.QUEUED && newStatus == JobStatus.RUNNING) {
            this.status = newStatus;
        } else if (this.status == JobStatus.RUNNING && (newStatus == JobStatus.COMPLETED || newStatus == JobStatus.FAILED)) {
            this.status = newStatus;
        } else {
            throw new InvalidJobStateTransitionException(
                "Cannot transition from " + this.status + " to " + newStatus
            );
        }
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
