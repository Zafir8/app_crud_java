package com.saberion.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saberion.app.model.User;
import com.saberion.app.repository.UserRepository;
import com.saberion.app.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        System.out.println("Login attempt with email: " + email);

        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("User found with email: " + user.getEmail());
            System.out.println("Stored hashed password: " + user.getPassword());

            if (passwordEncoder.matches(password, user.getPassword())) {
                System.out.println("Password matched");
                return jwtUtil.generateToken(user.getEmail(), user.getRole().name());
            } else {
                System.out.println("Password did not match");
            }
        } else {
            System.out.println("User not found");
        }
        throw new RuntimeException("Invalid credentials");
    }

    
    public static class LoginRequest {
        private String email;
        private String password;

        
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
