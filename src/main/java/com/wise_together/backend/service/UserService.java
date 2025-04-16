package com.wise_together.backend.service;

import com.wise_together.backend.entity.User;
import com.wise_together.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService service;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register (User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
            return JWTService.generateToken(user.getUsername());

        return "Fail";
    }
}
