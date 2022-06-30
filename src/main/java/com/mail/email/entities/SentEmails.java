package com.mail.email.entities;

import javax.persistence.*;

@Entity
@Table(name = "mail_reports")
public class SentEmails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Email;
    String StatusResponse;

    public SentEmails() {
    }

    public SentEmails(String email, String statusResponse) {
        Email = email;
        StatusResponse = statusResponse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getStatusResponse() {
        return StatusResponse;
    }

    public void setStatusResponse(String statusResponse) {
        StatusResponse = statusResponse;
    }
}
