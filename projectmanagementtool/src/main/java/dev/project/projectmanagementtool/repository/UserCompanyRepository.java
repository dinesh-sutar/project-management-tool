package dev.project.projectmanagementtool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.UserCompany;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {

    List<UserCompany> findByUserIdAndStatus(Long userId, String status);

    List<UserCompany> findByCompanyId(Long companyId);
}
