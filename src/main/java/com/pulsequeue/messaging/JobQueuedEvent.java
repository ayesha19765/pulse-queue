package com.pulsequeue.messaging;

import com.pulsequeue.domain.JobPriority;

import java.util.UUID;

public class JobQueuedEvent {

    private UUID jobId;
    private String jobName;
    private JobPriority priority;

    public JobQueuedEvent(UUID jobId, String jobName, JobPriority priority) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.priority = priority;
    }

    public UUID getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public JobPriority getPriority() {
        return priority;
    }
}

