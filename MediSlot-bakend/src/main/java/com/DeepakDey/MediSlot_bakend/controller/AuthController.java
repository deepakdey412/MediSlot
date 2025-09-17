package com.DeepakDey.MediSlot_bakend.controller;

import com.DeepakDey.MediSlot_bakend.dto.RegisterRequest;
import com.DeepakDey.MediSlot_bakend.entity.User;
import com.DeepakDey.MediSlot_bakend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        User user = authService.register(request);
        return ResponseEntity.ok("User registered successfully with id: " + user.getId());
    }
}

