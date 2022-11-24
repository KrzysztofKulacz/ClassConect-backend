package com.example.classconectbackend.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberDto;
import com.example.classconectbackend.utils.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/login")
public class LoginResource {

    @Value("${jwt.secret}")
    private String secret;

    private final AuthenticationManager authenticationManager;

    public LoginResource(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<MemberDto> login(@RequestBody LoginRequest loginRequest) {

        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        var member = (Member) authentication.getPrincipal();
        var memberDto = MemberMapper.mapToDto(member);
        var jwtToken = generateToken(member);
        var headers = new HttpHeaders();

        headers.add("JWT-TOKEN", jwtToken);

        return new ResponseEntity<>(memberDto, headers, HttpStatus.OK);
    }

    private String generateToken(Member member) {

        return JWT.create()
                .withSubject(member.getEmail())
                .withIssuer("ClassConnect")
                .withClaim("ROLES", member.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(Algorithm.HMAC256(secret));
    }
}
