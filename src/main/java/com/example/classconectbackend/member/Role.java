package com.example.classconectbackend.member;

public enum Role {

    STUDENT(new String[]{"VIEW_GROUPS", "DELETE_GROUPS"}), TEACHER(new String[]{"VIEW_GROUPS", "DELETE_GROUPS"});

    private final String[] description;

    Role(String[] description) {
        this.description = description;
    }

    public String[] getDescription() {
        return description;
    }

}
