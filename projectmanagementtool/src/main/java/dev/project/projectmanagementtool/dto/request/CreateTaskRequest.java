package dev.project.projectmanagementtool.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskRequest {

    @NotBlank
    private String title;

    private String description;

    private Long projectId;

    private Long userId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
