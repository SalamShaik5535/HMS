package com.health.controller;

import com.health.entity.ClinicalRecord;
import com.health.serivce.ClinicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinical")
@RequiredArgsConstructor
public class ClinicalController {

    private final ClinicalService service;

    @PostMapping
    public ResponseEntity<ClinicalRecord> create(@RequestBody ClinicalRecord record) {
        return ResponseEntity.ok(service.createRecord(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalRecord> update(
            @PathVariable String id,
            @RequestBody ClinicalRecord updatedRecord) {
        return ResponseEntity.ok(service.updateRecord(id, updatedRecord));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalRecord>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getByPatientId(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<ClinicalRecord>> getByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(service.getByDoctorId(doctorId));
    }
}
