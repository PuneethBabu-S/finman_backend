package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.LoginRequestDTO;
import com.pbs.finman_backend.dto.RegisterRequestDTO;
import com.pbs.finman_backend.entity.User;
import com.pbs.finman_backend.repository.UserRepository;
import com.pbs.finman_backend.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequestDTO request) {
        userRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    logger.warn("Registration failed: Email already in use - {}", request.getEmail());
                    throw new IllegalArgumentException("Email already in use");
                });

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    public String login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> {
                    logger.warn("Login failed: Invalid credentials for email - {}", request.getEmail());
                    return new IllegalArgumentException("Invalid credentials");
                });

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            logger.warn("Login failed: Invalid password for email - {}", request.getEmail());
            throw new IllegalArgumentException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
