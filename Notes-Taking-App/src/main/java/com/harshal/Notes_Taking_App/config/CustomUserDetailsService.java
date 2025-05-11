package com.harshal.Notes_Taking_App.config;

import com.harshal.Notes_Taking_App.entity.User;
import com.harshal.Notes_Taking_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        else {
            return new CustomUser(user);
        }
    }
}
