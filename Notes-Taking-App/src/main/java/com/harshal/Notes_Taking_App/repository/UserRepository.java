package com.harshal.Notes_Taking_App.repository;

import com.harshal.Notes_Taking_App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //public boolean findByEmail(String email);

    public boolean existsByEmail(String email);

    public User findByEmail(String email);
}
