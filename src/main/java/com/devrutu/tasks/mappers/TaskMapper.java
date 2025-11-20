package com.devrutu.tasks.mappers;

import com.devrutu.tasks.domain.dto.TaskDto;
import com.devrutu.tasks.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
