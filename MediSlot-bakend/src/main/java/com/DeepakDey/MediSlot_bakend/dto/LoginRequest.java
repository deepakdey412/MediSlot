package com.DeepakDey.MediSlot_bakend.dto;

public class LoginRequest {
    private String contact;
    private String password;


    public LoginRequest() {
    }

    public LoginRequest(String contact, String password) {
        this.contact = contact;
        this.password = password;
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
}
