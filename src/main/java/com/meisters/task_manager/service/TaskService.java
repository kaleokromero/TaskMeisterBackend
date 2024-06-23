package com.meisters.task_manager.service;

import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.data.domain.Sort;
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
        b. tasks can only be updated or deleted if in status pending;
        c. tasks can only be deleted if its creation date is older than 5 days ago.
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
        Sort sort = Sort.by("priority").descending()
        .and(Sort.by("due_date").ascending());
        return tasksRepository.findAll(sort);
    }

    public List<Tasks> update(Tasks tasks) {
        if (tasks.getStatus().equals("PENDING")) {
            tasksRepository.save(tasks);
            return list();
        } else {
            throw new IllegalArgumentException
            ("Tasks can only be updated or deleted if current status is pending");
        }
    }

    public List<Tasks> delete(Long id) {
        Tasks task = tasksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        if (task.getStatus().equals("PENDING")) {
            tasksRepository.deleteById(id);
            return list();
        } else {
            throw new IllegalArgumentException
            ("Tasks can only be deleted if current status is pending");
        }
    }
}
