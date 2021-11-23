package com.ramich.testTask.services;

import com.ramich.testTask.entities.Note;
import com.ramich.testTask.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private NoteRepo noteRepo;

    @Autowired
    public void setNoteRepo(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public void addNote(Note note) {
        noteRepo.save(note);
    }

    @Override
    public List<Note> getNotesByUsername(String username) {
        return noteRepo.findByUsername(username);
    }

    @Override
    public List<Note> getHistory10(String username) {
        return noteRepo.history10NotesByUsername(username);
    }
}
