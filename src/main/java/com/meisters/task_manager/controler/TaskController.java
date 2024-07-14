package com.meisters.task_manager.controler;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meisters.task_manager.entity.Tasks;
import com.meisters.task_manager.service.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/{id}")
    public Tasks list(@PathVariable Long id) {
        return taskService.list(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @PutMapping("/{id}")
    List<Tasks> update(@PathVariable Long id, @RequestBody Tasks tasks) {
        return taskService.update(id, tasks);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<List<Tasks>> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        Tasks.status status = Tasks.status.valueOf(requestBody.get("status"));
        List<Tasks> updatedTasks = taskService.updateStatus(id, status);
        return ResponseEntity.ok(updatedTasks);
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/{id}")
    List<Tasks> delete(@PathVariable Long id) {
        return taskService.delete(id);
    }
}
