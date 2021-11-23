package com.ramich.testTask.controllers;

import com.ramich.testTask.config.JwtFilter;
import com.ramich.testTask.config.JwtProvider;
import com.ramich.testTask.entities.Note;
import com.ramich.testTask.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(name = "/notes")
public class NotesController {

    private NoteService noteService;
    private JwtProvider jwtProvider;
    private JwtFilter jwtFilter;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @Autowired
    public void setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Autowired
    public void setJwtFilter(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @PostMapping
    public void addNote(@RequestBody MessageRequest messageRequest){
        //вытащить username из токена и засунуть в note
        Note note = new Note();
        note.setText(messageRequest.getMessage());
        note.setUsername("Ram2");
        noteService.addNote(note);
    }

    @GetMapping
    public String test(){
        return "Authenticated message!";
    }

    /*@GetMapping
    public List<Note> history10(@RequestBody MessageRequest messageRequest){
        //вытащить username из токена и засунуть в note
        noteService.getHistory10();
    }*/
}
