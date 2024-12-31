package com.saberion.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saberion.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
