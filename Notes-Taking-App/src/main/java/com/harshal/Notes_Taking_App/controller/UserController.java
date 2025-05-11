package com.harshal.Notes_Taking_App.controller;

import ch.qos.logback.core.testUtil.NPEAppender;
import com.harshal.Notes_Taking_App.entity.Notes;
import com.harshal.Notes_Taking_App.entity.User;
import com.harshal.Notes_Taking_App.repository.UserRepository;
import com.harshal.Notes_Taking_App.service.NotesService;
import jakarta.servlet.http.HttpSession;
import org.aspectj.weaver.ast.Not;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotesService notesService;

    @ModelAttribute
    public User getUser(Principal principal, Model model) {
        String email = principal.getName();
        User user = this.userRepository.findByEmail(email);

        model.addAttribute("user", user);

        return user;
    }

    @GetMapping("/add-notes")
    public String addNotes() {
        return "add-notes";
    }

    @GetMapping("/view-notes")
    public String viewNotes(Model model, Principal principal) {
        User user = getUser(principal, model);
        System.out.println(user);
        List<Notes> listOfNotesByUser = this.notesService.getNotesByUser(user);
        System.out.println(listOfNotesByUser);
        model.addAttribute("ListOfNotesByUser", listOfNotesByUser);
        return "view-notes";
    }

    @GetMapping("edit-notes/{id}")
    public String editNotes(@PathVariable("id") Integer id, Model model) {
        //Notes notes = this.notesService.noteById(id);
        Notes notes = this.notesService.getNotesById(id).get();
        model.addAttribute("notes", notes);
        return "edit-notes";
    }

    @PostMapping("/save-notes")
    public String saveNotes(@ModelAttribute Notes notes, HttpSession session, Principal principal, Model model) {
        notes.setCreatedAt(LocalDate.now());
        notes.setUser(getUser(principal, model));

        Notes saveNotes = this.notesService.saveNotes(notes);

        if(saveNotes != null) {
            session.setAttribute("message", "Note Saved Successfullly!");
        }
        else {
            session.setAttribute("message", "Something went wrong!");
        }

        return "redirect:/user/add-notes";
    }

    @PostMapping("/update-notes")
    public String updateNotes(@ModelAttribute Notes notes, HttpSession session, Principal principal, Model model) {
        notes.setCreatedAt(LocalDate.now());
        notes.setUser(getUser(principal, model));

        Notes saveNotes = this.notesService.saveNotes(notes);

        if(saveNotes != null) {
            session.setAttribute("message", "Note Updated Successfullly!");
        }
        else {
            session.setAttribute("message", "Something went wrong!");
        }

        return "redirect:/user/view-notes";
    }

    @GetMapping("/delete-notes/{id}")
    public String deleteNotes(@PathVariable("id") Integer id, HttpSession session) {
        boolean deleteNotes = this.notesService.deleteNotes(id);
        if(deleteNotes) {
            session.setAttribute("message", "Note Deleted Successfully!");
        }else {
            session.setAttribute("message", "Something went wrong");
        }

        return "redirect:/user/view-notes";
    }



}
