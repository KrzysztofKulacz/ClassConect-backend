package com.example.classconectbackend.member;

public enum Role {

    STUDENT(new String[]{"VIEW_GROUPS", "DELETE_GROUPS"}), TEACHER(new String[]{"VIEW_GROUPS", "DELETE_GROUPS", "EDIT_GROUPS"});

    private final String[] authorities;

    Role(String[] authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }

}
