package com.pbs.finman_backend.controller;

import com.pbs.finman_backend.dto.AuthResponseDTO;
import com.pbs.finman_backend.dto.LoginRequestDTO;
import com.pbs.finman_backend.dto.RegisterRequestDTO;
import com.pbs.finman_backend.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequestDTO request) {
        authService.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        String token = authService.login(request);
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}
