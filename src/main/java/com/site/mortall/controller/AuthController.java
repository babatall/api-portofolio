package com.site.mortall.controller;

import com.site.mortall.dto.LoginRequest;
import com.site.mortall.dto.LoginResponse;
import com.site.mortall.entity.Utilisateur;
import com.site.mortall.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.motDePasse())
        );

        Utilisateur utilisateur = (Utilisateur) authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.motDePasse()))
                .getPrincipal();

        String token = jwtUtil.generateToken(utilisateur);
        return new LoginResponse(token, utilisateur.getEmail(), utilisateur.getRole().name());
    }
}