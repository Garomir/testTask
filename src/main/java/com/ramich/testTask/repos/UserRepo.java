package com.ramich.testTask.repos;

import com.ramich.testTask.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    //Ищем пользователя по username
    User findByUsername(String username);
}