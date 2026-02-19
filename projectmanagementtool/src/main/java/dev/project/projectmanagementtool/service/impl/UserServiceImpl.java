package dev.project.projectmanagementtool.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.project.projectmanagementtool.constant.EmploymentStatus;
import dev.project.projectmanagementtool.dto.request.RegisterUserRequest;
import dev.project.projectmanagementtool.dto.response.UserResponse;
import dev.project.projectmanagementtool.exception.BadRequestException;
import dev.project.projectmanagementtool.exception.NotFoundException;
import dev.project.projectmanagementtool.mapper.MapperUtil;
import dev.project.projectmanagementtool.model.Company;
import dev.project.projectmanagementtool.model.UserCompany;
import dev.project.projectmanagementtool.model.Users;
import dev.project.projectmanagementtool.repository.CompanyRepository;
import dev.project.projectmanagementtool.repository.UserCompanyRepository;
import dev.project.projectmanagementtool.repository.UserRepository;
import dev.project.projectmanagementtool.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final CompanyRepository companyRepo;
    private final UserCompanyRepository userCompanyRepo;

    @Override
    public UserResponse register(RegisterUserRequest req) {

        if (userRepo.existsByEmail(req.getEmail()))
            throw new BadRequestException("Email already exists");

        Company company = companyRepo.findById(req.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found"));

        Users u = new Users();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());

        userRepo.save(u);

        UserCompany uc = new UserCompany();
        uc.setUser(u);
        uc.setCompany(company);
        uc.setDesignation(req.getDesignation());
        uc.setStatus(EmploymentStatus.ACTIVE);

        userCompanyRepo.save(uc);

        return MapperUtil.toUserResponse(u);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepo.findAll().stream()
                .map(MapperUtil::toUserResponse)
                .toList();
    }
}
