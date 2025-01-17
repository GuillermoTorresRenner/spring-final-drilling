package com.devateleur.estudiantes_front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devateleur.estudiantes_front.model.AlumnoDTO;
import com.devateleur.estudiantes_front.service.AlumnoService;
import com.devateleur.estudiantes_front.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            HttpServletResponse response,
            Model model) {
        try {
            String accessToken = userService.signin(username, password);
            session.setAttribute("accessToken", accessToken);

            Cookie cookie = new Cookie("accessToken", accessToken);
            cookie.setHttpOnly(true); // Asegura que la cookie no sea accesible desde JavaScript
            cookie.setSecure(true); // Asegura que la cookie solo se envíe a través de HTTPS
            cookie.setPath("/"); // Define el path para el cual la cookie es válida
            cookie.setMaxAge(60 * 60); // Define el tiempo de vida de la cookie en segundos (1 hora)

            // Agregar la cookie a la respuesta
            response.addCookie(cookie);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "Credenciales invalidas ");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {
        String token = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("accessToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }

        if (token != null) {
            List<AlumnoDTO> listaAlumnos = alumnoService.findAll(token);
            model.addAttribute("alumnos", listaAlumnos);
        } else {
            return "redirect:/";
        }

        return "home";
    }

}