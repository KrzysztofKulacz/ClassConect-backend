package com.example.classconectbackend;

import com.example.classconectbackend.configuration.properties.MailProperties;
import com.example.classconectbackend.mail.EmailDetails;
import com.example.classconectbackend.mail.MailSenderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class ClassConectBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassConectBackendApplication.class, args);
    }

}
