package com.harshal.Notes_Taking_App.service.impl;

import com.harshal.Notes_Taking_App.entity.User;
import com.harshal.Notes_Taking_App.repository.UserRepository;
import com.harshal.Notes_Taking_App.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    @Override
    public boolean emailExistOrNot(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public void removeSessionMessage() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        session.removeAttribute("message");
    }
}
