package com.oleksandramala.elective.entities;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private String name;
    private String surname;
    private Role role;



    public static User create(){return new User();}
    private User(){}



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
