package com.example.classconectbackend.register;

import com.example.classconectbackend.configuration.properties.BackendProperties;
import com.example.classconectbackend.mail.EmailDetails;
import com.example.classconectbackend.mail.MailSender;
import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RegisterService {

    private final MemberRepository memberRepository;
    private final MailSender mailSender;
    private final BackendProperties backendProperties;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(MemberRepository memberRepository, MailSender mailSender,
                           BackendProperties backendProperties, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.mailSender = mailSender;
        this.backendProperties = backendProperties;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewMember(RegisterRequest registerRequest) {
        var newMember = new Member();
        var now = LocalDateTime.now();
        var activationCode = UUID.randomUUID();

        newMember.setUsername(registerRequest.getUsername());
        newMember.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newMember.setEmail(registerRequest.getEmail());
        newMember.setRole(registerRequest.getRole());
        newMember.setAuthorities(registerRequest.getRole().getAuthorities());
        newMember.setCreationDate(now);
        newMember.setActivationCode(activationCode);

        var savedMember = memberRepository.save(newMember);
        mailSender.sendEmail(prepareRegisterMessage(savedMember));
    }

    private EmailDetails prepareRegisterMessage(Member member) {
        return new EmailDetails(
                "classconnect",
                member.getEmail(),
                "Welcome to ClassConnect " + member.getNickName() + ". In order to activate, click link: http://" +
                        backendProperties.getHost() + ":" +
                        backendProperties.getPort() + "/v1/register/activate-member?activationCode=" +
                        member.getActivationCode(),
                "Welcome to Classconnect"
        );
    }

    public void activateMember(String activationCode) {

        var uuidActivationCode = UUID.fromString(activationCode);
        var registeredMember = memberRepository.findByActivationCode(uuidActivationCode).orElseThrow(() -> new IllegalStateException("Member doesn't exist"));

        registeredMember.setAccountNonExpired(true);
        registeredMember.setAccountNonLocked(true);
        registeredMember.setCredentialsNonExpired(true);
        registeredMember.setEnabled(true);

        memberRepository.save(registeredMember);

    }
}
