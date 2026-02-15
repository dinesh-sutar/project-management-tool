package dev.project.projectmanagementtool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Boolean existsByEmail(String email);
}
