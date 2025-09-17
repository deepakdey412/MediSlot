package com.DeepakDey.MediSlot_bakend.service;

import com.DeepakDey.MediSlot_bakend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto
}
