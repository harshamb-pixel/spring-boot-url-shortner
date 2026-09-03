package com.harsha.spring_boot_url_shortner.domain.models;

public record CreateUserCmd(
        String email,
        String password,
        String name,
        Role role) {
}
