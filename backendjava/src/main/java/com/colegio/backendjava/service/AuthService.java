package com.colegio.backendjava.service;

import com.colegio.backendjava.model.Usuario;
import org.springframework.stereotype.Service;

@Service // ← SOLO @Service
public class AuthService {

    public Usuario login(String username, String pass) {
        // Simulación para probar
        if ("Admin".equals(username) && "1234".equals(pass)) {
            Usuario user = new Usuario();
            user.setUsername("Admin");
            user.setRole("ADMIN");
            return user;
        }
        return null;
    }

    public Usuario register(Usuario usuario) {
        // Lógica de registro...
        return usuario;
    }
}
