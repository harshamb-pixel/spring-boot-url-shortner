package com.harsha.spring_boot_url_shortner.domain.repositories;

import com.harsha.spring_boot_url_shortner.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}