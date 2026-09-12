package com.pulsequeue.persistence;

import com.pulsequeue.domain.Job;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresJobRepository implements JobRepository {

    private final SpringDataJobRepository springDataJobRepository;

    public PostgresJobRepository(SpringDataJobRepository springDataJobRepository) {
        this.springDataJobRepository = springDataJobRepository;
    }

    @Override
    public Job save(Job job) {
        JobEntity entity = JobMapper.toEntity(job);
        JobEntity savedEntity = springDataJobRepository.save(entity);
        return JobMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Job> findById(UUID id) {
        return springDataJobRepository.findById(id)
                .map(JobMapper::toDomain);
    }
}

