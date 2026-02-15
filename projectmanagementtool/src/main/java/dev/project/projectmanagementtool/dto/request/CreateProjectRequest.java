package dev.project.projectmanagementtool.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequest {

    @NotBlank
    private String name;

    private String description;

    private String status;

    private Long companyId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
