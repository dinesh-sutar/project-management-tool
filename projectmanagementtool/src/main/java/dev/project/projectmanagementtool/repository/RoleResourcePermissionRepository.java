package dev.project.projectmanagementtool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.projectmanagementtool.model.RoleResourcePermission;

public interface RoleResourcePermissionRepository
        extends JpaRepository<RoleResourcePermission, Long> {

    List<RoleResourcePermission> findByRoleIdAndAllowedTrue(Long roleId);
}
