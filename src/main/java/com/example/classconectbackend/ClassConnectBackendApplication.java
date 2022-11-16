package com.example.classconectbackend;

import com.example.classconectbackend.configuration.properties.MailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class ClassConnectBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassConnectBackendApplication.class, args);
    }

}
