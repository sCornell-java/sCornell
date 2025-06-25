package com.planner.planner.service;

import com.planner.planner.dto.PlanDTO;
import com.planner.planner.dto.UpdateDTO;
import com.planner.planner.entity.PlanEntity;
import com.planner.planner.repository.PlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlannerService {
    @Autowired
    PlanRepository planRepository;

    public List<PlanDTO> getAllPlans() {
        return planRepository.findAll().stream().map(entity -> {
            PlanDTO dto = new PlanDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setDetail(entity.getDetail());
            dto.setDate(entity.getDate());
            return dto;
        }).collect(Collectors.toList());
    }

    public boolean registerPlan(PlanDTO planDTO) {
        PlanEntity planEntity = new PlanEntity();
        planEntity.setId(planDTO.getId());
        planEntity.setTitle(planDTO.getTitle());
        planEntity.setDetail(planDTO.getDetail());
        planEntity.setDate(planDTO.getDate());
        PlanEntity saved = planRepository.save(planEntity);
        return saved != null;
    }

    public boolean updatePlan(String id, UpdateDTO updateDTO) {
        Optional<PlanEntity> optional = planRepository.findById(id);
        if (optional.isPresent()) {
            PlanEntity planEntity = optional.get();
            planEntity.setTitle(updateDTO.getTitle());
            planEntity.setDetail(updateDTO.getDetail());
            planRepository.save(planEntity);
            return true;
        }
        return false;
    }
}
