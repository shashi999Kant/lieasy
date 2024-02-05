package com.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.load.entities.Loading;

public interface LoadRepo extends JpaRepository<Loading, Long> {
    List<Loading> findByShipperId(Long shipperId);
}

