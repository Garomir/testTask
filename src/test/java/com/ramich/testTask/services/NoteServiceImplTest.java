package com.ramich.testTask.services;

import com.ramich.testTask.entities.Note;
import com.ramich.testTask.repos.NoteRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {

    @Mock
    private NoteRepo noteRepo;
    @Mock
    private Note note1;
    @Mock
    private Note note2;
    @Mock
    private Note note3;
    @InjectMocks
    private NoteServiceImpl noteService;

    private List<Note> notes = null;

    @BeforeEach
    void setUp() {
        notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
    }

    @Test
    void addNote() {
    }

    @Test
    void deleteNote() {
    }

    @Test
    void getNotesByUsername() {
        when(noteRepo.findByUsername("Ramil")).thenReturn(notes);
        List<Note> testList = noteService.getNotesByUsername("Ramil");
        assertEquals(3, notes.size());
    }
}