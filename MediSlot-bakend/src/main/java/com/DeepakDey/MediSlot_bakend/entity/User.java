package com.DeepakDey.MediSlot_bakend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    // Contact number is used as login instead of email
    @Column(nullable = false, unique = true, length = 15)
    private String contactNumber;

    @Column(nullable = false)
    private String password;

    @Column(length = 150)
    private String email; // Optional, for notifications

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role; // PATIENT, DOCTOR, ADMIN

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Address information
    @Column(length = 500)
    private String address;

    @Column(length = 100)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 10)
    private String pincode;

    @Column
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Profile image path
    @Column(length = 255)
    private String profileImagePath;

    // PrePersist and PreUpdate for timestamps
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // TODO: Add constructors (default, parameterized)
    // TODO: Add all getters and setters
    // TODO: Add equals() and hashCode() methods
    // TODO: Add toString() method
}