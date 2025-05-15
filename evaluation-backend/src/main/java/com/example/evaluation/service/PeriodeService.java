package com.example.evaluation.service;


import com.example.evaluation.dto.PeriodeDto;
import com.example.evaluation.mapper.PeriodeMapper;
import com.example.evaluation.model.Periode;
import com.example.evaluation.model.PeriodeId;
import com.example.evaluation.repository.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeriodeService {
    @Autowired
    private PeriodeRepository periodeRepository;

    @Autowired
    private PeriodeMapper periodeMapper;

    public List<PeriodeDto> findAll() {
        return periodeRepository.findAll().stream()
                .map(periodeMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PeriodeDto> findById(Object id) {
        return periodeRepository.findById((PeriodeId) id).map(periodeMapper::toDto);
    }

    public PeriodeDto save(PeriodeDto dto) {
        Periode periode = periodeMapper.toEntity(dto);
        return periodeMapper.toDto(periodeRepository.save(periode));
    }

    public void delete(Object id) {
        periodeRepository.deleteById((PeriodeId) id);
    }
}
