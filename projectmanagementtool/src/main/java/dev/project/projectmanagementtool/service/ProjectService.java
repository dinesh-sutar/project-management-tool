package dev.project.projectmanagementtool.service;

import java.util.List;

import dev.project.projectmanagementtool.dto.request.CreateProjectRequest;
import dev.project.projectmanagementtool.dto.response.ProjectResponse;

public interface ProjectService {

    ProjectResponse createProject(CreateProjectRequest request);

    List<ProjectResponse> byCompany(Long companyId);

    // ProjectResponse getById(Long id);
}
