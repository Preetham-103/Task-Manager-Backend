package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskDTO;

import java.util.List;

public interface ITaskService {

    TaskDTO createTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTasks();
    TaskDTO updateTask(Long taskId, TaskDTO dto);
    void deleteTask(Long taskId);
    List<TaskDTO> findByStatus(String status);
    List<TaskDTO> searchTasks(String query);


}
