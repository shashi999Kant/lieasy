package com.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.load.entities.Load;

public interface LoadRepo extends JpaRepository<Load, Long> {
    List<Load> findByShipperId(Long shipperId);
}

