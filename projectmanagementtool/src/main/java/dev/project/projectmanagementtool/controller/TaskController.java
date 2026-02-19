package dev.project.projectmanagementtool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.projectmanagementtool.dto.request.CreateTaskRequest;
import dev.project.projectmanagementtool.dto.response.TaskResponse;
import dev.project.projectmanagementtool.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public TaskResponse create(@RequestBody @Valid CreateTaskRequest req) {
        return service.createTask(req);
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponse> byProject(@PathVariable Long projectId) {
        return service.byProject(projectId);
    }
}
