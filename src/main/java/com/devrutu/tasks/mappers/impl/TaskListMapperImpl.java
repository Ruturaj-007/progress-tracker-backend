package com.devrutu.tasks.mappers.impl;

// TaskListMapperImpl — is responsible for converting between your entity (TaskList) and its DTO (TaskListDto), while also mapping the inner tasks (Task) using another mapper (TaskMapper).

import com.devrutu.tasks.domain.dto.TaskListDto;
import com.devrutu.tasks.domain.entities.Task;
import com.devrutu.tasks.domain.entities.TaskList;
import com.devrutu.tasks.domain.entities.TaskStatus;
import com.devrutu.tasks.mappers.TaskListMapper;
import com.devrutu.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper; // DI

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto)
                                .toList()
                        ).orElse(null)
        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }

        long closedTasksCount = tasks.stream()  // List<Task> into a stream, which lets us process data like a flow
                .filter(task -> TaskStatus.CLOSED.name().equals(task.getStatus()))
                .count();


        return (double) closedTasksCount / tasks.size();
    }
}