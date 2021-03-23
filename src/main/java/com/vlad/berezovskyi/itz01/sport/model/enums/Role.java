package com.vlad.berezovskyi.itz01.sport.model.enums;

public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String name;

    Role(String name) {
        this.name = name;
    }
}
