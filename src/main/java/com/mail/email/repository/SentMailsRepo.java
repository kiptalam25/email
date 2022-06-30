package com.mail.email.repository;

import com.mail.email.entities.SentEmails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentMailsRepo extends JpaRepository<SentEmails,Integer> {

}
