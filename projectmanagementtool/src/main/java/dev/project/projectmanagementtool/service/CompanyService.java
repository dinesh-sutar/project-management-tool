package dev.project.projectmanagementtool.service;

import java.util.List;

import dev.project.projectmanagementtool.dto.request.CreateCompanyRequest;
import dev.project.projectmanagementtool.dto.response.CompanyResponse;

public interface CompanyService {
    CompanyResponse create(CreateCompanyRequest req);

    List<CompanyResponse> getAll();
}
