package dev.project.projectmanagementtool.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.project.projectmanagementtool.dto.request.CreateCompanyRequest;
import dev.project.projectmanagementtool.dto.response.CompanyResponse;
import dev.project.projectmanagementtool.exception.BadRequestException;
import dev.project.projectmanagementtool.mapper.MapperUtil;
import dev.project.projectmanagementtool.model.Company;
import dev.project.projectmanagementtool.repository.CompanyRepository;
import dev.project.projectmanagementtool.service.CompanyService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repo;

    public CompanyResponse create(CreateCompanyRequest req) {

        if (repo.existsByName(req.getName()))
            throw new BadRequestException("Company exists");

        Company c = new Company();
        c.setName(req.getName());
        c.setRegistrationNumber(req.getRegistrationNumber());
        c.setEmail(req.getEmail());

        repo.save(c);

        return MapperUtil.toCompanyResponse(c);
    }

    public List<CompanyResponse> getAll() {
        return repo.findAll().stream()
                .map(MapperUtil::toCompanyResponse)
                .toList();
    }
}
