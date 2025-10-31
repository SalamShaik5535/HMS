package com.health.service;


import com.health.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(String doctorId, DoctorDTO doctorDTO);
    DoctorDTO getDoctorById(String doctorId);
    List<DoctorDTO> getAllDoctors();
    void deleteDoctor(String doctorId);
}

