package com.meisters.task_manager.controler;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meisters.task_manager.entity.Tasks;
import com.meisters.task_manager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @PostMapping
    List<Tasks> create(@RequestBody Tasks tasks) {
        return taskService.create(tasks);
    }

    @GetMapping
    List<Tasks> list() {
        return taskService.list();    
    }

    @PutMapping("/{id}")
    List<Tasks> update(@RequestBody Tasks tasks) {
        return taskService.update(tasks);
    }

    @DeleteMapping("/{id}")
    List<Tasks> delete(Long id) {
        return taskService.delete(id);
    }
}
