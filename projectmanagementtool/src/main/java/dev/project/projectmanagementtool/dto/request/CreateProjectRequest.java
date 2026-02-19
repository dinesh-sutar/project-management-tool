package dev.project.projectmanagementtool.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequest {

    @NotBlank
    private String name;

    private String description;

    private String status;

    @NotNull
    private Long companyId;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<ProjectMemberRequest> members;

    @Getter
    @Setter
    public static class ProjectMemberRequest {

        private Long userId;
        private String roleName;
    }
}
