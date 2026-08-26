package com.harsha.spring_boot_url_shortner.domain.models;


import java.io.Serializable;
import java.time.Instant;

public record ShortUrlDto(Long id, String shortKey, String originalUrl,
                          Boolean isPrivate, Instant expiresAt,
                          UserDto createdBy, Long clickCount,
                          Instant createdAt) implements Serializable {
}
