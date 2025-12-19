package com.colegio.backendjava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)

    private String username;
    private String pass;
    private String email;
    private String role; // ADMIN o STUDENT
    // constructores, getters y setters...

    // Constructor vacío (OBLIGATORIO para JPA)
    public Usuario() {
    }

    public Usuario(String username, String pass, String email, String role) {
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.role = role;
    }

    // ========== GETTERS Y SETTERS ==========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ========== MÉTODOS ADICIONALES (opcionales) ==========

    /*
     * @Override
     * public String toString() {
     * return "Usuario{" +
     * "id=" + id +
     * ", username='" + username + '\'' +
     * ", email='" + email + '\'' +
     * ", role='" + role + '\'' +
     * '}';
     * }
     */
}
