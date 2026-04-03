package org.kafkalab.data;

import org.kafkalab.model.KafkaMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for storing and reading {@link KafkaMessageEntity} demo records.
 */
@Repository
public interface KafkaMessageRepository extends JpaRepository<KafkaMessageEntity, Integer> {
}
