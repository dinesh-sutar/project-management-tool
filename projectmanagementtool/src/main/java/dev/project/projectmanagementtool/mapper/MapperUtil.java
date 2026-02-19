package dev.project.projectmanagementtool.mapper;

import dev.project.projectmanagementtool.dto.response.CompanyResponse;
import dev.project.projectmanagementtool.dto.response.ProjectResponse;
import dev.project.projectmanagementtool.dto.response.TaskResponse;
import dev.project.projectmanagementtool.dto.response.UserResponse;
import dev.project.projectmanagementtool.model.Company;
import dev.project.projectmanagementtool.model.Project;
import dev.project.projectmanagementtool.model.Task;
import dev.project.projectmanagementtool.model.Users;

public class MapperUtil {

    public static UserResponse toUserResponse(Users u) {
        UserResponse r = new UserResponse();
        r.setId(u.getId());
        r.setName(u.getName());
        r.setEmail(u.getEmail());
        r.setActive(u.getActive());
        return r;
    }

    public static CompanyResponse toCompanyResponse(Company c) {
        CompanyResponse r = new CompanyResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setEmail(c.getEmail());
        r.setRegistrationNumber(c.getRegistrationNumber());
        r.setActive(c.getActive());
        return r;
    }

    public static ProjectResponse toProjectResponse(Project p) {
        ProjectResponse r = new ProjectResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setDescription(p.getDescription());
        r.setStatus(p.getStatus() != null ? p.getStatus().name() : null);
        r.setCompanyId(p.getCompany().getId());
        return r;
    }

    public static TaskResponse toTaskResponse(Task t) {
        TaskResponse r = new TaskResponse();
        r.setId(t.getId());
        r.setTitle(t.getTitle());
        r.setDescription(t.getDescription());
        r.setProgress(t.getProgress());
        r.setStatus(t.getStatus() != null ? t.getStatus().name() : null);
        r.setProjectId(t.getProject().getId());
        return r;
    }
}
