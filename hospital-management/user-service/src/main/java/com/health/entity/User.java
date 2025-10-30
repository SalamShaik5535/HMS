package com.health.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keycloakId;   // maps to Keycloak's user UUID
    private String username;
    private String email;
    private String fullName;
    private String role;         // e.g., ROLE_DOCTOR, ROLE_NURSE
    private String department;
    private String contactNumber;
    private String gender;
    private String address;
}
