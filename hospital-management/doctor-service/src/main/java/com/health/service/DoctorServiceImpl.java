package com.health.service;

import com.health.dto.DoctorDTO;
import com.health.entity.Doctor;
import com.health.event.DoctorEventProducer;
import com.health.repo.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final ModelMapper mapper = new ModelMapper();
    private final DoctorEventProducer eventProducer;

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = mapper.map(doctorDTO, Doctor.class);
        doctor.setDoctorId(UUID.randomUUID().toString());
        Doctor saved = repository.save(doctor);
        eventProducer.publishDoctorCreated(saved);
        return mapper.map(saved, DoctorDTO.class);
    }

    @Override
    public DoctorDTO updateDoctor(String doctorId, DoctorDTO doctorDTO) {
        Doctor existing = repository.findByDoctorId(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        existing.setName(doctorDTO.getName());
        existing.setSpecialization(doctorDTO.getSpecialization());
        existing.setEmail(doctorDTO.getEmail());
        existing.setPhone(doctorDTO.getPhone());
        existing.setStatus(doctorDTO.getStatus());
        Doctor updated = repository.save(existing);
        return mapper.map(updated, DoctorDTO.class);
    }

    @Override
    public DoctorDTO getDoctorById(String doctorId) {
        Doctor doctor = repository.findByDoctorId(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return mapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return repository.findAll()
                .stream()
                .map(d -> mapper.map(d, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDoctor(String doctorId) {
        Doctor doctor = repository.findByDoctorId(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        repository.delete(doctor);
    }
}
