package com.wise_together.backend.service;

import com.wise_together.backend.entity.User;
import com.wise_together.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register (User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
