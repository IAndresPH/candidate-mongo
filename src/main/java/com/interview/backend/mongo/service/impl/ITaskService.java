package com.interview.backend.mongo.service.impl;

import com.interview.backend.mongo.dto.request.TaskRequestDto;
import com.interview.backend.mongo.dto.response.TaskResponseDto;
import java.util.List;
import java.util.Optional;

public interface ITaskService {
    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    Optional<TaskResponseDto> getTaskById(String id);
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto updateTask(String id, TaskRequestDto taskRequestDto);
    void deleteTask(String id);
    void taskMade(String id);
}