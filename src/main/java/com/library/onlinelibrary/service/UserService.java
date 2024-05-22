package com.library.onlinelibrary.service;

import com.library.onlinelibrary.model.Users;
import com.library.onlinelibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Users> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
