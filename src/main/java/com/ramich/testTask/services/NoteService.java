package com.ramich.testTask.services;

import com.ramich.testTask.entities.Note;

import java.util.List;

public interface NoteService {
    void addNote(Note note);
    void deleteNote(int noteId);
    List<Note> getNotesByUsername(String username);
    List<Note> getHistory10(String username);
}
