package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;


    @GetMapping
    public List<Task> getTasks(@RequestParam(value = "search", required = false) String search) {
        if (search != null && !search.trim().isEmpty()) {
            return taskRepository.searchTasks(search);
        } else {
            return taskRepository.findAll();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO)
    {
        return ResponseEntity.ok(taskService.createTask(taskDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        try {
            List<TaskDTO> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            e.printStackTrace(); // 👈 prints the exact reason for 500 error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long taskId, @RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.updateTask(taskId, taskDTO));
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bystatus")
    public ResponseEntity<List<TaskDTO>> byStatus(@RequestParam String status){
        return ResponseEntity.ok(taskService.findByStatus(status));
    }
    @GetMapping("/search")
    public List<TaskDTO> searchTasks(@RequestParam String query) {
        return taskService.searchTasks(query);
    }

}
