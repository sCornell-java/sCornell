package com.planner.planner.service;

import com.planner.planner.dto.PlanDTO;
import com.planner.planner.dto.SuccessRequestDTO;
import com.planner.planner.dto.UpdateDTO;
import com.planner.planner.entity.PlanEntity;
import com.planner.planner.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlannerService {
    @Autowired
    private final PlanRepository planRepository;

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

    @Transactional
    public boolean deletePlan(String id) {
        if (!planRepository.existsById(id)) {
            log.info("Plan could not be deleted - id not found: {}", id);
            return false;
        }
        try {
            planRepository.deleteById(id);
            log.info("Plan has been deleted - id: {}", id);
            return true;
        } catch (Exception e) {
            log.error("Error deleting plan with id {}: {}", id, e.getMessage(), e);
            return false;
        }
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

    public boolean changeResultPlan(SuccessRequestDTO successRequestDTO) {
        Optional<PlanEntity> optionalPlanEntity = planRepository.findById(successRequestDTO.getId());

        if (optionalPlanEntity.isPresent()) {
            PlanEntity planEntity = optionalPlanEntity.get();
            planEntity.setSuccess(successRequestDTO.isSuccess()); // DTO의 값 그대로 반영
            planRepository.save(planEntity);
            System.out.println("if 문 안");
            return true;
        }
        System.out.println("if 문 밖");
        return false;
    }
}