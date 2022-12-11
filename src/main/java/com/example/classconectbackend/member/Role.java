package com.example.classconectbackend.member;

public enum Role {

    STUDENT(new String[]{"VIEW_GROUPS", "JOIN_GROUPS", "SEARCH_GROUP","EDIT_OWN_POST","DELETE_OWN_POST"}),
    TEACHER(new String[]{"VIEW_GROUPS", "JOIN_GROUPS", "SEARCH_GROUP","ADD_GROUP",
            "DELETE_OWN_GROUPS", "EDIT_OWN_GROUPS","EDIT_EVERY_POST_IN_OWN_GROUP","DELETE_EVERY_POST_IN_OWN_GROUP"});

    private final String[] authorities;

    Role(String[] authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }

}
