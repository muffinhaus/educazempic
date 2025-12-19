package com.colegio.backendjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/")
    public String home() {
        return "{\"status\":\"público ok\"}";
    }

    @GetMapping("/login")
    public String login() {
        return "{\"message\":\"Login endpoint OK\"}";
    }
}
