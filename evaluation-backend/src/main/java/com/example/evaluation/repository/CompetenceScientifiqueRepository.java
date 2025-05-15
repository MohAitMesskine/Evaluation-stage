package com.example.evaluation.repository;

import com.example.evaluation.model.CompetenceScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceScientifiqueRepository extends JpaRepository<CompetenceScientifique, Long> {
}

