package com.ramich.testTask.repos;

import com.ramich.testTask.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findByUsername(String username);
}