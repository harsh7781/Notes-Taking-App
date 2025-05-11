package com.harshal.Notes_Taking_App.service.impl;

import com.harshal.Notes_Taking_App.entity.Notes;
import com.harshal.Notes_Taking_App.entity.User;
import com.harshal.Notes_Taking_App.repository.NotesRepository;
import com.harshal.Notes_Taking_App.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepository notesRepository;


    @Override
    public boolean deleteNotes(Integer noteId) {
        Optional<Notes> notes = this.notesRepository.findById(noteId);
        if(notes.isPresent()) {
            this.notesRepository.deleteById(noteId);
            return true;
        }
        return false;
    }

    @Override
    public Notes saveNotes(Notes notes) {
        return this.notesRepository.save(notes);
    }

    @Override
    public Optional<Notes> getNotesById(Integer noteId) {
        return this.notesRepository.findById(noteId);
    }

    @Override
    public List<Notes> getNotesByUser(User user) {
        List<Notes> userNotes = this.notesRepository.findByUser(user);
        return userNotes;
    }

    @Override
    public Notes noteById(Integer noteId) {
        return this.notesRepository.findById(noteId).get();
    }

    @Override
    public Notes updateNotes(Notes notes) {
        System.out.println("Notes updated : " + notes.getId());
        return this.notesRepository.save(notes);
    }
}
