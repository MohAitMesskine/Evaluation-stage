package com.example.evaluation.repository;

import com.example.evaluation.model.CompetenceEntreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceEntrepriseRepository extends JpaRepository<CompetenceEntreprise, Long> {
}
