package com.interview.backend.mongo.mapper;

import com.interview.backend.mongo.dto.request.TaskRequestDto;
import com.interview.backend.mongo.dto.response.TaskResponseDto;
import com.interview.backend.mongo.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task mapToEntity(TaskRequestDto dto){
        if(dto == null) return null;
        Task task = new Task();

        task.setTittle(dto.tittle());
        task.setText(dto.text());
        task.setAuthor(dto.author());
        task.setAssigned(dto.assigned());

        return task;
    }

    public TaskResponseDto mapToDto(Task task){
        if(task == null) return null;

        return new TaskResponseDto(
                task.getId(),
                task.getTittle(),
                task.getText(),
                task.getAuthor(),
                task.getAssigned(),
                task.getCompleted()
        );
    }
}