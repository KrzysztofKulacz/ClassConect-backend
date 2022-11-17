package com.example.classconectbackend.member;

public enum Role {

    STUDENT("student"), TEACHER("teacher");

    //...TODO zmienić role, zrobić jako lista stringów



    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
