package dev.project.projectmanagementtool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.projectmanagementtool.dto.request.RegisterUserRequest;
import dev.project.projectmanagementtool.dto.response.UserResponse;
import dev.project.projectmanagementtool.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid RegisterUserRequest req) {
        return service.register(req);
    }

    @GetMapping
    public List<UserResponse> all() {
        return service.getAll();
    }
}
