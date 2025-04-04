package com.wise_together.backend.service;

import com.wise_together.backend.entity.User;
import com.wise_together.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User add (User user) {
        return repo.save(user);
    }
}
