package com.ramich.testTask.repos;

import com.ramich.testTask.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}