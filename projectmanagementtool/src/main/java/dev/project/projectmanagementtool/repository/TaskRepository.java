package dev.project.projectmanagementtool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByProjectId(Long projectId);

}
