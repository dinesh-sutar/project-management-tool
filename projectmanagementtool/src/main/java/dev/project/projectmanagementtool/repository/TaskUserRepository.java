package dev.project.projectmanagementtool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.TaskUser;

public interface TaskUserRepository extends JpaRepository<TaskUser, Long> {

    List<TaskUser> findByUserId(Long userId);

    List<TaskUser> findByTaskId(Long taskId);
}
