package com.health.event;



import com.health.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishDoctorCreated(Doctor doctor) {
        kafkaTemplate.send("doctor-topic", doctor);
        System.out.println("📢 Doctor created event published to Kafka for: " + doctor.getName());
    }

    public void publishDoctorUpdated(Doctor doctor) {
        kafkaTemplate.send("doctor-topic", doctor);
        System.out.println("📢 Doctor updated event published to Kafka for: " + doctor.getName());
    }
}
