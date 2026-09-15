package com.pulsequeue.application;

import com.pulsequeue.domain.Job;
import com.pulsequeue.domain.JobPriority;
import com.pulsequeue.domain.JobStatus;
import com.pulsequeue.persistence.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(String name, JobPriority priority) {
        Job job = new Job(name, priority);
        return jobRepository.save(job);
    }

    public Optional<Job> findJob(UUID id) {
        return jobRepository.findById(id);
    }

    public Job startJob(UUID id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job not found: " + id));
        job.transitionTo(JobStatus.RUNNING);
        return jobRepository.save(job);
    }
}
