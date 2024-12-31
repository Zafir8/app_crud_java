package com.saberion.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saberion.app.model.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
    List<Attribute> findByProductId(Integer productId);
}
