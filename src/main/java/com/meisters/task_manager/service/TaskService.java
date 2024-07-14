package com.meisters.task_manager.service;

import java.util.List;
import java.util.Optional;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.meisters.task_manager.entity.Tasks;
import com.meisters.task_manager.repository.TasksRepository;

@Service
public class TaskService {
    private TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    /*  a. tasks can only be created during weekdays;
        b. tasks can only be deleted if status is pending;
    */

    public List<Tasks> create(Tasks tasks) {
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY || LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("Task can only be created during weekdays");
        } else {
            tasksRepository.save(tasks);
            return list();    
        }
    }
    
    public List<Tasks> list() {
        return tasksRepository.findAll();
    }

    public Optional<Tasks> list(Long id) {
        return tasksRepository.findById(id);
    }
    
    public List<Tasks> update(Long id, Tasks tasks) {       
        Tasks task = tasksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setName(tasks.getName());
        task.setDescription(tasks.getDescription());
        task.setDueDate(tasks.getDueDate());
        task.setStatus(tasks.getStatus());
        task = tasksRepository.save(task);
        return list();
    }
    
    public List<Tasks> updateStatus(Long id, Tasks.status status) {
        Tasks task = tasksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setStatus(status);
        task = tasksRepository.save(task);
        return list();
    }

    public List<Tasks> delete(Long id) {
        Tasks task = tasksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        if (task.getStatus().equals(Tasks.status.PENDING) || task.getStatus().equals(Tasks.status.COMPLETED)) {
            tasksRepository.deleteById(id);
            return tasksRepository.findAll();
        } else {
            throw new IllegalArgumentException
            ("Tasks can only be deleted if current status is pending");
        }
    }
}
