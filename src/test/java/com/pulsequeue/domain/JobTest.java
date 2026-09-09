package com.pulsequeue.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JobTest {

    @Test
    void createsJobWithInitialState() {
        Job job = new Job("image-resize", JobPriority.HIGH);

        assertNotNull(job.getId());
        assertEquals("image-resize", job.getName());
        assertEquals(JobPriority.HIGH, job.getPriority());
        assertEquals(JobStatus.QUEUED, job.getStatus());
        assertNotNull(job.getCreatedAt());
    }
}

