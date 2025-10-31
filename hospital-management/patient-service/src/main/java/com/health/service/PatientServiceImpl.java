package com.health.service;

import com.health.entity.Patient;
import com.health.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements  PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> listAllPatients() {
        return  patientRepository.findAll();
    }

    @Override
    public String updatePatientById(Long patientId, Patient patient) {
        Patient pid = patientRepository.findById(patientId).orElseThrow(()->new RuntimeException("Patient Not Found"));
        if(pid!=null){
            pid.setDiagnosis(patient.getDiagnosis());
            pid.setAssignedDoctor(patient.getAssignedDoctor());
            pid.setRoomNo(patient.getRoomNo());
        }
        return "Patient Details Updated With ID :"+pid;
    }

    @Override
    public String getPatientById(Long patientId) {
        Optional<Patient> pid = patientRepository.findById(patientId);
        Patient patient=null;
        if (pid.isPresent()) {
         patient = pid.get();
        }
        return patient.getPatientId() + " " + patient.getPatientName() + " " + patient.getDiagnosis() + " " + patient.getAssignedDoctor() + " " + patient.getRoomNo();
    }

    @Override
    public String deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
        return "Patient Deleted With ID :"+patientId;
    }
}
