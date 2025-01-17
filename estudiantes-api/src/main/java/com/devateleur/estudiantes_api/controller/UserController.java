package com.devateleur.estudiantes_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devateleur.estudiantes_api.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

import com.devateleur.estudiantes_api.model.User;
import com.devateleur.estudiantes_api.security.JwtProvider;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody Map<String, String> credenciales, HttpServletResponse response) {
        String username = credenciales.get("username");
        String password = credenciales.get("password");

        try {
            User user = userService.signin(username, password);
            String accessToken = jwtProvider.generateToken(user.getUsername(), user.getRole().toString());
            return ResponseEntity.status(200).body(accessToken);
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        try {
            User newUser = userService.signup(user);
            return ResponseEntity.status(200).body(newUser);

        } catch (Exception ex) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
