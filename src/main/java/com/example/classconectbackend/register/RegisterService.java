package com.example.classconectbackend.register;

import com.example.classconectbackend.mail.EmailDetails;
import com.example.classconectbackend.mail.MailSenderImpl;
import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterService {

    private final MemberRepository memberRepository;
    private final MailSenderImpl mailSender;


    @Autowired
    public RegisterService(MemberRepository memberRepository, MailSenderImpl mailSender) {
        this.memberRepository = memberRepository;
        this.mailSender = mailSender;
    }

    public void registerNewMember(RegisterRequest registerRequest) {
        var newMember = new Member();
        var now = LocalDateTime.now();
        var activationCode = UUID.randomUUID();

        newMember.setUsername(registerRequest.getUsername());
        newMember.setPassword(registerRequest.getPassword());
        newMember.setEmail(registerRequest.getEmail());
        newMember.setRole(registerRequest.getRole());
        newMember.setAuthorities(registerRequest.getAuthorities());
        newMember.setCreationDate(now);
        newMember.setActivationCode(activationCode);

        var savedMember = memberRepository.save(newMember);
        mailSender.sendEmail(prepareRegisterMessage(savedMember));
    }

    private EmailDetails prepareRegisterMessage(Member member) {
        return new EmailDetails(
                "classconnect",
                member.getEmail(),
                "Welcome to ClassConnect. In order to activate, click link: http://localhost:8080/v1/register/activate-member?activationCode=" + member.getActivationCode(),
                "Welcome to Classconnect"
        );
    }

    public void activateMember(String activationCode) {

        var uuidActivationCode = UUID.fromString(activationCode);
        var registeredMember = memberRepository.findByActivationCode(uuidActivationCode).orElseThrow(() -> new RuntimeException("Member doesn't exist"));

        registeredMember.setAccountNonExpired(true);
        registeredMember.setAccountNonLocked(true);
        registeredMember.setCredentialsNonExpired(true);
        registeredMember.setEnabled(true);

        memberRepository.save(registeredMember);

    }
}
