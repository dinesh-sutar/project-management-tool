package dev.project.projectmanagementtool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByCompanyId(Long companyId);

}
