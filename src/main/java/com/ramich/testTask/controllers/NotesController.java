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

    //Инжектим зависимости

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

    //Эндпоинты
    //добавляем новую заметку по имени пользователя
    @PostMapping
    public void addNote(HttpServletRequest request, @RequestBody MessageRequest messageRequest){
        Note note = new Note();
        note.setText(messageRequest.getMessage());
        note.setUsername(getUsernameFromRequest(request));
        noteService.addNote(note);
    }

    //получаем все заметки по имени пользователя
    @GetMapping
    public List<Note> allNotes(HttpServletRequest request){
        return noteService.getNotesByUsername(getUsernameFromRequest(request));
    }

    //получаем последние 10 заметок по имени пользователя
    @GetMapping("/history10")
    public List<Note> history10(HttpServletRequest request){
        return noteService.getHistory10(getUsernameFromRequest(request));
    }

    //удаляем заметку по его id
    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable("noteId") int noteId){
        noteService.deleteNote(noteId);
    }

    //достаем username из токена, который берем из входящего запроса HttpServletRequest
    private String getUsernameFromRequest(HttpServletRequest request){
        String token = jwtFilter.getTokenFromRequest(request);
        return jwtProvider.getLoginFromToken(token);
    }
}
