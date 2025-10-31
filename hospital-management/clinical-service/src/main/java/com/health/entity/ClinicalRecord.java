package com.health.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clinical_records")
public class ClinicalRecord {

    @Id
    private String id;
    private Long patientId;
    private Long doctorId;

    private List<String> diagnoses;
    private List<String> medications;
    private List<String> allergies;
    private List<String> labResults;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
