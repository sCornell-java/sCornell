package com.planner.planner.service;

import com.planner.planner.repository.PlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlannerService {
    private final PlanRepository planRepository;

    public PlannerService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public boolean deletePlan(String id) {
        if (planRepository.existsById(id)) {
            planRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
