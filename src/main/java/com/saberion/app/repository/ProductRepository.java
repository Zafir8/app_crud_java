package com.saberion.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saberion.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCodeContainingOrNameContaining(String code, String name);
}
