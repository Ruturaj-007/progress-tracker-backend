package com.devrutu.tasks.domain.dto;

// (DTO) Data Transfer object is used to send data from backend -> frontend without exposing the db entity
// We don’t expose internal entity fields like foreign keys, lazy-loaded relationships

import com.devrutu.tasks.domain.entities.TaskPriority;
import com.devrutu.tasks.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto (
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        String status
) {
}
