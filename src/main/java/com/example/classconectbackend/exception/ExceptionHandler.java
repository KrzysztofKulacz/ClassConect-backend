package com.example.classconectbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    private static final String WRONG_PASSWORD = "Podane hasło jest nieprawidłowe";
    private static final String USER_ALREADY_EXISTS = "Zalogowany użytkownik już jest w tej grupie";
    private static final String NO_SUCH_TEAM = "Wskazana grupa nie istnieje";
    private static final String INCORRECT_JOIN_REQ = "Nie można znaleźć grupy dla przekazanych danych";

    @org.springframework.web.bind.annotation.ExceptionHandler(IncorrectTeamPasswordException.class)
    public ResponseEntity<String> handleIncorrectPasswordTeam() {
        return new ResponseEntity<>(WRONG_PASSWORD, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MemberExistsInTeamException.class)
    public ResponseEntity<String> handleMemberExistsWithinTeam() {
        return new ResponseEntity<>(USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchTeamException.class)
    public ResponseEntity<String> handleNoSuchTeam() {
        return new ResponseEntity<>(NO_SUCH_TEAM, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IncorrectJoinRequest.class)
    public ResponseEntity<String> handleIncorrectJoinRequest() {
        return new ResponseEntity<>(INCORRECT_JOIN_REQ, HttpStatus.BAD_REQUEST);
    }
}
