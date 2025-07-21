package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import org.modelmapper.ModelMapper;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService{

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = modelMapper.map(taskDTO, Task.class);
        return modelMapper.map(taskRepository.save(task),TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task,TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO updateTask(Long taskId, TaskDTO dto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()->new RuntimeException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getTitle());
        task.setStatus(dto.getStatus());
        task.setDueDate(dto.getDueDate());
        return modelMapper.map(taskRepository.save(task), TaskDTO.class);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);

    }

    @Override
    public List<TaskDTO> findByStatus(String status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<TaskDTO> searchTasks(String query) {
        List<Task> tasks = taskRepository.searchTasks(query);
        return tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());
    }

}
