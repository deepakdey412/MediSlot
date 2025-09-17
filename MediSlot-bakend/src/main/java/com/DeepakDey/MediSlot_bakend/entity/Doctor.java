package com.DeepakDey.MediSlot_bakend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-one relationship with User entity
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 50)
    private String licenseNumber;

    @Column(nullable = false, length = 100)
    private String specialization;

    @Column(nullable = false)
    private Integer experienceYears;

    @Column(length = 100)
    private String qualification;

    @Column(length = 1000)
    private String biography;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal consultationFee;

    // Doctor approval status by admin
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DoctorStatus status = DoctorStatus.PENDING; // PENDING, APPROVED, REJECTED, SUSPENDED

    @Column
    private Double rating = 0.0;

    @Column
    private Integer totalReviews = 0;

    // Document paths for verification
    @Column(length = 255)
    private String licenseDocumentPath;

    @Column(length = 255)
    private String qualificationDocumentPath;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Doctor() {
    }

    public Doctor(User user, String licenseNumber, String specialization, Integer experienceYears,
                  String qualification, String biography, BigDecimal consultationFee,
                  DoctorStatus status, Double rating, Integer totalReviews,
                  String licenseDocumentPath, String qualificationDocumentPath) {
        this.user = user;
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.qualification = qualification;
        this.biography = biography;
        this.consultationFee = consultationFee;
        this.status = status;
        this.rating = rating;
        this.totalReviews = totalReviews;
        this.licenseDocumentPath = licenseDocumentPath;
        this.qualificationDocumentPath = qualificationDocumentPath;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public BigDecimal getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        this.consultationFee = consultationFee;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getLicenseDocumentPath() {
        return licenseDocumentPath;
    }

    public void setLicenseDocumentPath(String licenseDocumentPath) {
        this.licenseDocumentPath = licenseDocumentPath;
    }

    public String getQualificationDocumentPath() {
        return qualificationDocumentPath;
    }

    public void setQualificationDocumentPath(String qualificationDocumentPath) {
        this.qualificationDocumentPath = qualificationDocumentPath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", user=" + user +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", qualification='" + qualification + '\'' +
                ", biography='" + biography + '\'' +
                ", consultationFee=" + consultationFee +
                ", status=" + status +
                ", rating=" + rating +
                ", totalReviews=" + totalReviews +
                ", licenseDocumentPath='" + licenseDocumentPath + '\'' +
                ", qualificationDocumentPath='" + qualificationDocumentPath + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
