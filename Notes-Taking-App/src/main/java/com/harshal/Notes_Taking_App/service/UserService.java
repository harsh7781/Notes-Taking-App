package com.harshal.Notes_Taking_App.service;

import com.harshal.Notes_Taking_App.entity.User;

public interface UserService {

    User saveUser(User user);

    boolean emailExistOrNot(String email);

    public User getUserByEmail(String email);
}
