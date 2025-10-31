package com.health.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorId; // UUID or unique string
    private String name;
    private String specialization;
    private String email;
    private String phone;
    private String qualification;
    private int experienceYears;
    private String hospitalName;
    private String availability; // e.g., "Mon-Fri, 9AM-5PM"
    private String status; // ACTIVE, INACTIVE
}
