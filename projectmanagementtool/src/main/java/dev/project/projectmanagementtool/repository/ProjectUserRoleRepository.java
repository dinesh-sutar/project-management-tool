package dev.project.projectmanagementtool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.ProjectUserRole;

public interface ProjectUserRoleRepository
        extends JpaRepository<ProjectUserRole, Long> {

    Optional<ProjectUserRole> findByUserIdAndProjectId(
            Long userId, Long projectId);
}
