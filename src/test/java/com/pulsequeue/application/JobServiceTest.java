package com.pulsequeue.application;

import com.pulsequeue.domain.Job;
import com.pulsequeue.domain.JobPriority;
import com.pulsequeue.domain.JobStatus;
import com.pulsequeue.persistence.JobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    @Test
    void startsExistingJob() {
        Job job = new Job("test-job", JobPriority.NORMAL);

        when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));
        when(jobRepository.save(job)).thenReturn(job);

        Job startedJob = jobService.startJob(job.getId());

        assertEquals(JobStatus.RUNNING, startedJob.getStatus());
        verify(jobRepository, times(1)).save(job);
    }

    @Test
    void throwsExceptionWhenStartingNonExistingJob() {
        UUID nonExistingId = UUID.randomUUID();

        when(jobRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () ->
                jobService.startJob(nonExistingId)
        );
    }
}

