package com.jestify.controller;

import com.jestify.payload.RoleRequest;
import com.jestify.payload.RoleResponse;
import com.jestify.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Slf4j
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleResponse> getRoles() {
        log.info("Get All Roles");
        return roleService.getAll();
    }

    @PostMapping
    public void addRole(@RequestBody RoleRequest request) {
        roleService.addRole(request);
    }
}