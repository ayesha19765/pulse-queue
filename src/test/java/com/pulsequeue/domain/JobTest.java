package com.pulsequeue.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void transitionsFromQueuedToRunning() {
        Job job = new Job("image-resize", JobPriority.HIGH);

        job.transitionTo(JobStatus.RUNNING);

        assertEquals(JobStatus.RUNNING, job.getStatus());
    }

    @Test
    void transitionsFromRunningToCompleted() {
        Job job = new Job("image-resize", JobPriority.HIGH);
        job.transitionTo(JobStatus.RUNNING);

        job.transitionTo(JobStatus.COMPLETED);

        assertEquals(JobStatus.COMPLETED, job.getStatus());
    }

    @Test
    void transitionsFromRunningToFailed() {
        Job job = new Job("image-resize", JobPriority.HIGH);
        job.transitionTo(JobStatus.RUNNING);

        job.transitionTo(JobStatus.FAILED);

        assertEquals(JobStatus.FAILED, job.getStatus());
    }

    @Test
    void throwsExceptionWhenTransitioningFromQueuedToCompleted() {
        Job job = new Job("image-resize", JobPriority.HIGH);

        assertThrows(InvalidJobStateTransitionException.class, () ->
            job.transitionTo(JobStatus.COMPLETED)
        );
    }

    @Test
    void throwsExceptionWhenTransitioningFromCompletedToRunning() {
        Job job = new Job("image-resize", JobPriority.HIGH);
        job.transitionTo(JobStatus.RUNNING);
        job.transitionTo(JobStatus.COMPLETED);

        assertThrows(InvalidJobStateTransitionException.class, () ->
            job.transitionTo(JobStatus.RUNNING)
        );
    }
}
