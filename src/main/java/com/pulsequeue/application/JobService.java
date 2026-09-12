package com.pulsequeue.application;

import com.pulsequeue.domain.Job;
import com.pulsequeue.domain.JobPriority;
import com.pulsequeue.persistence.JobRepository;
import org.springframework.stereotype.Service;

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
}

