package com.example.classconectbackend.validation.annotations;

import com.example.classconectbackend.validation.validators.JoinTeamValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = JoinTeamValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface JoinTeamValidation {
    String message() default " ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
