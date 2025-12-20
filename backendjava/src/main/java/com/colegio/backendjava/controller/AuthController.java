package com.colegio.backendjava.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.colegio.backendjava.model.Usuario;
import com.colegio.backendjava.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String pass = request.get("pass");

        Optional<Usuario> opt = usuarioService.findByUsername(username);
        if (opt.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("error", "Usuario no encontrado"));
        }

        Usuario user = opt.get();
        if (!usuarioService.checkPassword(pass, user.getPass())) {
            return ResponseEntity.status(401).body(Map.of("error", "Contraseña incorrecta"));
        }

        Map<String, String> data = new HashMap<>();
        data.put("username", user.getUsername());
        data.put("role", user.getRole());
        return ResponseEntity.ok(data);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        try {
            String newUsername = request.get("newUsername");
            String newPass = request.get("newPass");
            Usuario newUser = usuarioService.registrar(newUsername, newPass);
            return ResponseEntity.ok(Map.of("message", "✅ Estudiante registrado",
                    "username", newUser.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error",
                    "Error al registrar"));
        }
    }

}
