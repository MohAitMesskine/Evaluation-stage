package com.example.evaluation.repository;

import com.example.evaluation.model.Appreciation;
import com.example.evaluation.model.AppreciationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppreciationRepository extends JpaRepository<Appreciation, AppreciationId> {
    Optional<Appreciation> findById(AppreciationId id);
}
