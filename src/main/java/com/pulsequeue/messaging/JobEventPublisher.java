package com.pulsequeue.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobEventPublisher {

    private final KafkaTemplate<String, JobQueuedEvent> kafkaTemplate;

    public JobEventPublisher(KafkaTemplate<String, JobQueuedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(JobQueuedEvent event) {
        kafkaTemplate.send("job-queued", event.getJobId().toString(), event);
    }
}

