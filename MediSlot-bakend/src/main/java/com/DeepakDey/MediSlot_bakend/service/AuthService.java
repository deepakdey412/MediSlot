package com.DeepakDey.MediSlot_bakend.service;

import com.DeepakDey.MediSlot_bakend.dto.RegisterRequest;
import com.DeepakDey.MediSlot_bakend.entity.Role;
import com.DeepakDey.MediSlot_bakend.entity.User;
import com.DeepakDey.MediSlot_bakend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {
        if(userRepository.existsByContact(request.getContact())) {
            throw new RuntimeException("User already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getContact())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole().toUpperCase()))
                .verified(false)
                .build();

        return  userRepository.save(user);
    }
}
