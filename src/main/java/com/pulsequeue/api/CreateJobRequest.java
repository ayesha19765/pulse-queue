package com.pulsequeue.api;

import com.pulsequeue.domain.JobPriority;

public class CreateJobRequest {

    private String name;
    private JobPriority priority;

    public CreateJobRequest() {
    }

    public CreateJobRequest(String name, JobPriority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public JobPriority getPriority() {
        return priority;
    }
}

