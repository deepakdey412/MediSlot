package com.DeepakDey.MediSlot_bakend.dto;

public class RegisterRequest {
    private String name;
    private String contact; // login contact number
    private String password;
    private String role; // PATIENT or DOCTOR

    public RegisterRequest() {
    }

    public RegisterRequest(String name, String contact, String password, String role) {
        this.name = name;
        this.contact = contact;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
