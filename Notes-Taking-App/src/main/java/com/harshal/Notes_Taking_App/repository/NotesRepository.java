package com.harshal.Notes_Taking_App.repository;

import com.harshal.Notes_Taking_App.entity.Notes;
import com.harshal.Notes_Taking_App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Integer> {

    List<Notes> findByUser(User user);
}
