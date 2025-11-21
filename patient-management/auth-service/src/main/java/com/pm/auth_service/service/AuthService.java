package com.pm.auth_service.service;

import com.pm.auth_service.dto.LoginRequestDTO;
import com.pm.auth_service.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<String> token = userService.findByEmail(loginRequestDTO.email())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.password(),
                        u.getPassword()))
                .map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole()));

        return token;
    }

    public boolean validateToken(String token) {
        try {
            jwtUtil.validateToken(token);
            return true;
        } catch (JwtException e){
            return false;
        }
    }

}
