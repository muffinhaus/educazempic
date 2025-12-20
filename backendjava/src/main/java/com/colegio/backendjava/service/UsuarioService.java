package com.colegio.backendjava.service;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.colegio.backendjava.model.Usuario;
import com.colegio.backendjava.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public Optional<Usuario> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    // ← NUEVO MÉTODO PARA REGISTRAR
    public Usuario registrar(String username, String rawPassword) {
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPass(encoder.encode(rawPassword)); // ENCRIPTA
        u.setRole("ROLE_STUDENT");
        return repo.save(u);
    }

    public void registrar(Usuario newUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrar'");
    }

}
