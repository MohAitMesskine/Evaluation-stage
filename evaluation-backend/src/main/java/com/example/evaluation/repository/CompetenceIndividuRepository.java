package com.example.evaluation.repository;

import com.example.evaluation.model.CompetenceIndividu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceIndividuRepository extends JpaRepository<CompetenceIndividu, Long> {
}
