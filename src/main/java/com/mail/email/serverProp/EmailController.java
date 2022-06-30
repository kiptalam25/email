package com.mail.email.serverProp;

import com.mail.email.entities.SentEmails;
import com.mail.email.repository.SentMailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SentMailsRepo sentMailsRepo;
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        List<EmailDetails> emailDetails =new ArrayList<>();
//        emailDetails.add(new EmailDetails("jessejzee@gmail.com","hello world","testing bulk",""));
//        emailDetails.add(new EmailDetails("kiptalamj@gmail.com","hello world","testing bulk",""));
//        emailDetails.add(new EmailDetails("kiptalamj@gmail.com","hello world","testing bulk",""));
//        emailDetails.add(new EmailDetails("kiptalamj@gmail.com","hello world","testing bulk",""));
//        emailDetails.add(new EmailDetails("jessejzee@gmail.com","hello world","testing bulk",""));
//        emailDetails.add(new EmailDetails("jessejzee@gmail.com","hello world","testing bulk",""));
//        emailDetails.add(new EmailDetails("jessejkjhgfzee@gmail.com","hello world","testing bulk",""));
        emailDetails.add(details);

        for (EmailDetails details1:emailDetails){
            String status= emailService.sendSimpleMail(details1);

            SentEmails sentEmails=new SentEmails();
            sentEmails.setEmail(details1.getRecipient());
            sentEmails.setStatusResponse(status);
            sentMailsRepo.save(sentEmails);
//            return status;
        }
        return "Completed";
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }
}
