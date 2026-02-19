package dev.project.projectmanagementtool.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.project.projectmanagementtool.constant.ProjectStatus;
import dev.project.projectmanagementtool.dto.request.CreateProjectRequest;
import dev.project.projectmanagementtool.dto.request.CreateProjectRequest.ProjectMemberRequest;
import dev.project.projectmanagementtool.dto.response.ProjectResponse;
import dev.project.projectmanagementtool.exception.NotFoundException;
import dev.project.projectmanagementtool.mapper.MapperUtil;
import dev.project.projectmanagementtool.model.Company;
import dev.project.projectmanagementtool.model.Project;
import dev.project.projectmanagementtool.model.ProjectUserRole;
import dev.project.projectmanagementtool.model.Role;
import dev.project.projectmanagementtool.model.Users;
import dev.project.projectmanagementtool.repository.CompanyRepository;
import dev.project.projectmanagementtool.repository.ProjectRepository;
import dev.project.projectmanagementtool.repository.ProjectUserRoleRepository;
import dev.project.projectmanagementtool.repository.RoleRepository;
import dev.project.projectmanagementtool.repository.UserRepository;
import dev.project.projectmanagementtool.service.ProjectService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepo;
    private final CompanyRepository companyRepo;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final ProjectUserRoleRepository purRepo;

    public ProjectResponse createProject(CreateProjectRequest req) {

        Company company = companyRepo.findById(req.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found"));

        Project p = new Project();
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setCompany(company);
        p.setStartDate(req.getStartDate());
        p.setEndDate(req.getEndDate());

        if (req.getStatus() != null)
            p.setStatus(ProjectStatus.valueOf(req.getStatus()));

        projectRepo.save(p);

        if (req.getMembers() != null) {
            for (ProjectMemberRequest m : req.getMembers()) {

                Users user = userRepo.findById(m.getUserId())
                        .orElseThrow(() -> new NotFoundException("User not found"));

                Role role = roleRepo.findByName(m.getRoleName())
                        .orElseThrow(() -> new NotFoundException("Role not found"));

                ProjectUserRole pur = new ProjectUserRole();
                pur.setProject(p);
                pur.setUser(user);
                pur.setRole(role);

                purRepo.save(pur);
            }
        }

        return MapperUtil.toProjectResponse(p);
    }

    public List<ProjectResponse> byCompany(Long companyId) {
        return projectRepo.findByCompanyId(companyId)
                .stream().map(MapperUtil::toProjectResponse).toList();
    }
}
