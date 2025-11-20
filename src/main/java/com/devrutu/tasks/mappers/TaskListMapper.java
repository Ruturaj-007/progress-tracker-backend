package com.devrutu.tasks.mappers;

import com.devrutu.tasks.domain.dto.TaskListDto;
import com.devrutu.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);


}
