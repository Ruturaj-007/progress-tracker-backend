package com.devrutu.tasks.mappers.impl;

// Mapper is like a helper class which converts one type of object into another
// DB layer(JPA) Task(Entity)  Represents DB table
// API layer     TaskDto       Data sent or received via API it's a frontend layer


import com.devrutu.tasks.domain.dto.TaskDto;
import com.devrutu.tasks.domain.entities.Task;
import com.devrutu.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component()
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) { // Convert DTO → Entity (When saving a new Task)
        return new Task(                   // takes a TaskDto (from frontend)
          taskDto.id(),                    // Creates a new Task entity(ready to be saved in DB)
          taskDto.title(),
          taskDto.description(),
          taskDto.dueDate(),
          taskDto.status(),
          taskDto.priority(),
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Task task) {   // Convert Entity → DTO  (When fetching Task)
        return new TaskDto(             // Takes the entity from DB
                task.getId(),           // Creates a clean TaskDto — only the fields your frontend needs
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
