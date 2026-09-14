package com.pulsequeue.api;

import com.pulsequeue.domain.JobPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateJobRequest {

    @NotBlank
    private String name;

    @NotNull
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
