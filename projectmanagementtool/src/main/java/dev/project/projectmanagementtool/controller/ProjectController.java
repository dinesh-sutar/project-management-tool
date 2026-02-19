package dev.project.projectmanagementtool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.projectmanagementtool.dto.request.CreateProjectRequest;
import dev.project.projectmanagementtool.dto.response.ProjectResponse;
import dev.project.projectmanagementtool.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @PostMapping
    public ProjectResponse create(@RequestBody @Valid CreateProjectRequest req) {
        return service.createProject(req);
    }

    @GetMapping("/company/{companyId}")
    public List<ProjectResponse> byCompany(@PathVariable Long companyId) {
        return service.byCompany(companyId);
    }
}
