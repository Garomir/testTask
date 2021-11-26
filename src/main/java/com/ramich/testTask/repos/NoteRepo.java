package com.ramich.testTask.repos;

import com.ramich.testTask.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    //Список заметок по username
    List<Note> findByUsername(String username);
    //используя sql запрос получаем последние 10 заметок по username
    @Query(value = "SELECT * FROM notes WHERE username = :username ORDER BY id DESC LIMIT 10",nativeQuery = true)
    List<Note> history10NotesByUsername(@Param("username") String username);
}