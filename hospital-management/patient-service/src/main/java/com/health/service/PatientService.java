package com.health.service;

import com.health.entity.Patient;

import java.util.List;

public interface PatientService {

    public Patient createPatient(Patient patient);
    public List<Patient> listAllPatients();
    public String updatePatientById(Long patientId,Patient patient);
    public String getPatientById(Long patientId);
    public String deletePatientById(Long patientId);
}
