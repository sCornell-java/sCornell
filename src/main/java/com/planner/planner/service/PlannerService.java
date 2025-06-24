package com.planner.planner.service;

import com.planner.planner.repository.PlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlannerService {
    @Autowired
    PlanRepository planRepository;

    public boolean deletePlan(String id) {
        if (planRepository.existsById(id)) {
            planRepository.deleteById(id);
            System.out.println("Plan has been deleted");
            return true;
        }
        System.out.println("Plan could not be deleted");
        System.out.println(id);
        return false;
    }
}
