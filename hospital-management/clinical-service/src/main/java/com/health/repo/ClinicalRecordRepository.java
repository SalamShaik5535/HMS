package com.health.repo;

import com.health.entity.ClinicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ClinicalRecordRepository extends MongoRepository<ClinicalRecord, String> {
    List<ClinicalRecord> findByPatientId(Long patientId);
    List<ClinicalRecord> findByDoctorId(Long doctorId);
}
