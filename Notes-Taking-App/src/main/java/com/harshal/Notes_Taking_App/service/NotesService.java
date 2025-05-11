package com.harshal.Notes_Taking_App.service;

import com.harshal.Notes_Taking_App.entity.Notes;
import com.harshal.Notes_Taking_App.entity.User;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    boolean deleteNotes(Integer id);

    Notes saveNotes(Notes notes);

    Optional<Notes> getNotesById(Integer noteId);

    List<Notes> getNotesByUser(User user);

    Notes noteById(Integer noteId);

    Notes updateNotes(Notes notes);
}
