package com.health.controller;

import com.health.entity.Patient;
import com.health.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/createPatient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
		return ResponseEntity.ok(patientService.createPatient(patient));
	}
	@GetMapping("/listAllPatients")
	public ResponseEntity<List<Patient>> listAllPatients(){
		return ResponseEntity.ok(patientService.listAllPatients());
	}
	@PutMapping("/updatePatientById/{patientId}")
	public ResponseEntity<String> updatePatientById(@PathVariable Long patientId,@RequestBody Patient patient){
		return ResponseEntity.ok(patientService.updatePatientById(patientId,patient));
	}
	@GetMapping("/getPatientById/{patientId}")
	public ResponseEntity<String> getPatientById(@PathVariable Long patientId){
		return ResponseEntity.ok(patientService.getPatientById(patientId));
	}
	@DeleteMapping("/deletePatiengById/{patientId}")
	public ResponseEntity<String> deletePatientById(@PathVariable Long patientId){
		return ResponseEntity.ok(patientService.deletePatientById(patientId));
	}

}
