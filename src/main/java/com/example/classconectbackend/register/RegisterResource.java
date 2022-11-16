package com.example.classconectbackend.register;

import com.example.classconectbackend.mail.MailSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/register")
public class RegisterResource {

    private final MailSender mailSender;
    private final RegisterService registerService;

    public RegisterResource(MailSender mailSender, RegisterService registerService) {
        this.mailSender = mailSender;
        this.registerService = registerService;
    }

    @PostMapping("/member")
    public ResponseEntity<Void> registerNewMember(@RequestBody RegisterRequest registerRequest){

        registerService.registerNewMember(registerRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/activate-member")
    public ResponseEntity<String> activateMember(@RequestParam(name = "activationCode") String activationCode){
        registerService.activateMember(activationCode);

        return new ResponseEntity<>("Activation succesed. You can now login to the app", HttpStatus.OK);
    }
}
