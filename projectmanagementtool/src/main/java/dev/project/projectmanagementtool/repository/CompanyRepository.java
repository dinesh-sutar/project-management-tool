package dev.project.projectmanagementtool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

    Boolean existsByName(String name);
}
