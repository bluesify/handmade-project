package com.example.handmade.model.dto;

import com.example.handmade.model.constant.RoleName;

public record RoleDto(
        Long roleId,
        RoleName roleName,
        String description
) {
}
