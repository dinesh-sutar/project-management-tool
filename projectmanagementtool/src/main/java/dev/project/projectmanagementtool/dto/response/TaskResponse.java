package dev.project.projectmanagementtool.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {

    private Long id;

    private String title;

    private String description;

    private Integer progress;

    private String status;

    private Long projectId;
}
