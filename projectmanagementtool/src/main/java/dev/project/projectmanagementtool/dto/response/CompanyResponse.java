package dev.project.projectmanagementtool.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponse {

    private Long id;

    private String name;

    private String email;

    private String registrationNumber;

    private Boolean active;
}
