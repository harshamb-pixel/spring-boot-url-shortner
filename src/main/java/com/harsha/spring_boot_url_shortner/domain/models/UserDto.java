package com.harsha.spring_boot_url_shortner.domain.models;

import java.io.Serializable;

public record UserDto(Long id, String name) implements Serializable {
}
