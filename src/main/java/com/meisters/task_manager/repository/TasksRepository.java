package com.meisters.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meisters.task_manager.entity.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

    
}
