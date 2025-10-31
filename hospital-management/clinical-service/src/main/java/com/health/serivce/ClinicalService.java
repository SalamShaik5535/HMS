package com.health.serivce;


import com.health.entity.ClinicalRecord;
import com.health.repo.ClinicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicalService {

    private final ClinicalRecordRepository repository;

    public ClinicalRecord createRecord(ClinicalRecord record) {
        record.setCreatedAt(LocalDateTime.now());
        record.setUpdatedAt(LocalDateTime.now());
        return repository.save(record);
    }

    public ClinicalRecord updateRecord(String id, ClinicalRecord updatedRecord) {
        ClinicalRecord existing = repository.findById(id).orElseThrow();
        existing.setDiagnoses(updatedRecord.getDiagnoses());
        existing.setMedications(updatedRecord.getMedications());
        existing.setAllergies(updatedRecord.getAllergies());
        existing.setLabResults(updatedRecord.getLabResults());
        existing.setNotes(updatedRecord.getNotes());
        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    public List<ClinicalRecord> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public List<ClinicalRecord> getByDoctorId(Long doctorId) {
        return repository.findByDoctorId(doctorId);
    }
}
