package dev.project.projectmanagementtool.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponse {

    private Long id;

    private String name;

    private String description;

    private String status;

    private Long companyId;
}
