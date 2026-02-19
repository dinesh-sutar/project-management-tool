package dev.project.projectmanagementtool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.projectmanagementtool.dto.request.CreateCompanyRequest;
import dev.project.projectmanagementtool.dto.response.CompanyResponse;
import dev.project.projectmanagementtool.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @PostMapping
    public CompanyResponse create(@RequestBody @Valid CreateCompanyRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<CompanyResponse> all() {
        return service.getAll();
    }
}
