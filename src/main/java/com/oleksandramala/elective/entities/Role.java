package com.oleksandramala.elective.entities;

public enum Role {
    ADMIN,
    CLIENT;

    public static Role getFor(int num){
        switch (num){
            case 1: return ADMIN;
            default:
            case 2: return CLIENT;
        }
    }
}
