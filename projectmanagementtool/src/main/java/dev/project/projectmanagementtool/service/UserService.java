package dev.project.projectmanagementtool.service;

import java.util.List;

import dev.project.projectmanagementtool.dto.request.RegisterUserRequest;
import dev.project.projectmanagementtool.dto.response.UserResponse;

public interface UserService {

    UserResponse register(RegisterUserRequest request);

    // UserResponse getById(Long id);

    List<UserResponse> getAll();
}
