package com.example.evaluation.repository;

import com.example.evaluation.model.Periode;
import com.example.evaluation.model.PeriodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, PeriodeId> {}