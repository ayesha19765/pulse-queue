package com.pulsequeue.persistence;

import com.pulsequeue.domain.Job;

public final class JobMapper {

    private JobMapper() {
    }

    public static JobEntity toEntity(Job job) {
        if (job == null) {
            return null;
        }

        JobEntity entity = new JobEntity();
        entity.setId(job.getId());
        entity.setName(job.getName());
        entity.setPriority(job.getPriority());
        entity.setStatus(job.getStatus());
        entity.setCreatedAt(job.getCreatedAt());
        return entity;
    }

    public static Job toDomain(JobEntity entity) {
        if (entity == null) {
            return null;
        }

        return Job.rehydrate(
            entity.getId(),
            entity.getName(),
            entity.getPriority(),
            entity.getStatus(),
            entity.getCreatedAt()
        );
    }
}
