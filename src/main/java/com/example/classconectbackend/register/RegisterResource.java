package com.example.classconectbackend.register;

import com.example.classconectbackend.mail.EmailDetails;
import com.example.classconectbackend.mail.MailSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterResource {

    private final MailSender mailSender;

    public RegisterResource(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody EmailDetails emailDetails){

        mailSender.sendEmail(emailDetails);

        return ResponseEntity.ok().body("Mail sent");
    }
}
