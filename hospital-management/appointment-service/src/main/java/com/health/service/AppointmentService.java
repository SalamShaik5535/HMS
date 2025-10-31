package com.health.service;


import com.health.entity.Appointment;
import com.health.repo.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;

    public Appointment create(Appointment appointment) {
        appointment.setStatus(com.health.entity.AppointmentStatus.SCHEDULED);
        return repository.save(appointment);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Optional<Appointment> getById(Long id) {
        return repository.findById(id);
    }

    public Appointment updateStatus(Long id, String status) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(Enum.valueOf(com.health.entity.AppointmentStatus.class, status));
        return repository.save(appointment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
