package com.ramich.testTask.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    private Note note1 = null;
    private Note note2 = null;
    private Note note3 = null;

    @BeforeEach
    void setUp() {
        note1 = new Note();
        note1.setText("note1");
        note1.setUsername("Ramil");
        note2 = new Note();
        note2.setText("note2");
        note2.setUsername("Tagir");
        note3 = new Note();
        note3.setText("note2");
        note3.setUsername("Tagir");
    }

    @Test
    public void createNote(){
        assertEquals("note1", note1.getText());
        assertEquals("Ramil", note1.getUsername());
        assertEquals("note2", note2.getText());
        assertEquals("Tagir", note2.getUsername());
    }

    @Test
    public void equalsNotes(){
        assertEquals(note2, note3);
    }

    @Test
    public void notEqualsNotes(){
        assertNotEquals(note1, note2);
    }
}