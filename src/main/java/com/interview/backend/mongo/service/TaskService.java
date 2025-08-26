package com.interview.backend.mongo.service;

import com.interview.backend.mongo.dto.request.TaskRequestDto;
import com.interview.backend.mongo.dto.response.TaskResponseDto;
import com.interview.backend.mongo.mapper.TaskMapper;
import com.interview.backend.mongo.repository.ITaskRepository;
import com.interview.backend.mongo.service.impl.ITaskService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(ITaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        var person = taskMapper.mapToEntity(taskRequestDto);
        var savedTask = taskRepository.save(person);
        return taskMapper.mapToDto(savedTask);
    }

    @Override
    public Optional<TaskResponseDto> getTaskById(String id) {
        return taskRepository.findById(id)
                .map(taskMapper::mapToDto);
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::mapToDto)
                .toList();
    }

    @Override
    public TaskResponseDto updateTask(String id, TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
