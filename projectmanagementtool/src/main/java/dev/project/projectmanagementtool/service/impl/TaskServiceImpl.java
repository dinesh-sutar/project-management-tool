package dev.project.projectmanagementtool.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.project.projectmanagementtool.constant.TaskStatus;
import dev.project.projectmanagementtool.dto.request.CreateTaskRequest;
import dev.project.projectmanagementtool.dto.response.TaskResponse;
import dev.project.projectmanagementtool.exception.NotFoundException;
import dev.project.projectmanagementtool.mapper.MapperUtil;
import dev.project.projectmanagementtool.model.Project;
import dev.project.projectmanagementtool.model.Task;
import dev.project.projectmanagementtool.model.TaskUser;
import dev.project.projectmanagementtool.model.Users;
import dev.project.projectmanagementtool.repository.ProjectRepository;
import dev.project.projectmanagementtool.repository.TaskRepository;
import dev.project.projectmanagementtool.repository.TaskUserRepository;
import dev.project.projectmanagementtool.repository.UserRepository;
import dev.project.projectmanagementtool.service.TaskService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepo;
    private final ProjectRepository projectRepo;
    private final UserRepository userRepo;
    private final TaskUserRepository taskUserRepo;

    public TaskResponse createTask(CreateTaskRequest req) {

        Project project = projectRepo.findById(req.getProjectId())
                .orElseThrow(() -> new NotFoundException("Project not found"));

        Task t = new Task();
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        t.setProject(project);
        t.setStartDate(req.getStartDate());
        t.setEndDate(req.getEndDate());
        t.setStatus(TaskStatus.OPEN);
        t.setProgress(0);

        taskRepo.save(t);

        if (req.getUserIds() != null) {
            for (Long uid : req.getUserIds()) {

                Users u = userRepo.findById(uid)
                        .orElseThrow(() -> new NotFoundException("User not found"));

                TaskUser tu = new TaskUser();
                tu.setTask(t);
                tu.setUser(u);
                tu.setAssignedAt(LocalDateTime.now());

                taskUserRepo.save(tu);
            }
        }

        return MapperUtil.toTaskResponse(t);
    }

    public List<TaskResponse> byProject(Long projectId) {
        return taskRepo.findByProjectId(projectId)
                .stream().map(MapperUtil::toTaskResponse).toList();
    }
}
