package com.ken.employee.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ken.employee.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, UUID> {

}
