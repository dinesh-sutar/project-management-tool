package dev.project.projectmanagementtool.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCompanyRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String registrationNumber;

    private String email;
}
