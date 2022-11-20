package com.example.classconectbackend.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static java.util.Objects.isNull;

@Converter
public class AuthoritiesConverter implements AttributeConverter<String[], String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(String[] authorities) {

        if (isNull(authorities)){
            throw new IllegalStateException("Authorities cannot be null!");
        }

        return String.join(DELIMITER, authorities);
    }

    @Override
    public String[] convertToEntityAttribute(String authorities) {

        if (isNull(authorities)) {
            throw new IllegalStateException("Authorities cannot be null!");
        }

        return authorities.split(DELIMITER);
    }
}
