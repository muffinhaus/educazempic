package com.colegio.backendjava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// ...
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios") // ← AQUÍ
public class Usuario {

    @Id
    private Long id;
    private String username;
    private String pass;
    private String role; // "ROLE_ADMIN" o "ROLE_STUDENT"

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
