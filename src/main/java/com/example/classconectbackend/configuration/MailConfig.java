package com.example.classconectbackend.configuration;

import com.example.classconectbackend.configuration.properties.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class MailConfig {

    private final MailProperties mailProperties;

    public MailConfig(MailProperties mailProperties) {
        this.mailProperties = mailProperties;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {

        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());

        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());

        var props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailProperties.getProtocol());
        props.put("mail.smtp.auth", mailProperties.getAuth());
        props.put("mail.smtp.ssl.trust", mailProperties.getSslTrust());
        props.put("mail.smtp.starttls.enable", mailProperties.getStarttlsEnable());
        props.put("mail.smtp.starttls.required", mailProperties.getStarttlsRequired());
        props.put("mail.debug", mailProperties.getDebug());

        return mailSender;
    }
}