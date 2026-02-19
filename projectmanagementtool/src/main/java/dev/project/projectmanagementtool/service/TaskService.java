package dev.project.projectmanagementtool.service;

import java.util.List;

import dev.project.projectmanagementtool.dto.request.CreateTaskRequest;
import dev.project.projectmanagementtool.dto.response.TaskResponse;

public interface TaskService {

    TaskResponse createTask(CreateTaskRequest request);

    List<TaskResponse> byProject(Long projectId);

}
