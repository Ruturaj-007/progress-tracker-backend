package com.devrutu.tasks.repositories;

import com.devrutu.tasks.domain.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // allows CRUD behaviour
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {

}
