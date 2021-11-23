package com.ramich.testTask.controllers;

import com.ramich.testTask.config.JwtFilter;
import com.ramich.testTask.config.JwtProvider;
import com.ramich.testTask.entities.Note;
import com.ramich.testTask.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/notes")
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
    public void addNote(HttpServletRequest request, @RequestBody MessageRequest messageRequest){
        //вытащить username из токена
        String token = jwtFilter.getTokenFromRequest(request);
        String username = jwtProvider.getLoginFromToken(token);

        Note note = new Note();
        note.setText(messageRequest.getMessage());
        note.setUsername(username);
        noteService.addNote(note);
    }

    @GetMapping
    public List<Note> allNotes(HttpServletRequest request){
        String token = jwtFilter.getTokenFromRequest(request);
        String username = jwtProvider.getLoginFromToken(token);

        return noteService.getNotesByUsername(username);
    }

    @GetMapping("/history10")
    public List<Note> history10(HttpServletRequest request){
        String token = jwtFilter.getTokenFromRequest(request);
        String username = jwtProvider.getLoginFromToken(token);

        return noteService.getHistory10(username);
    }
}
