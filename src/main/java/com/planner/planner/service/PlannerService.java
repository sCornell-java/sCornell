package com.planner.planner.service;

import com.planner.planner.dto.SuccessRequestDTO;
import com.planner.planner.entity.PlanEntity;
import com.planner.planner.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlannerService {
    private final PlanRepository planRepository;

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
