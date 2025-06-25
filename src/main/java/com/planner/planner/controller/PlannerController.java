package com.planner.planner.controller;

import com.planner.planner.dto.PlanDTO;
import com.planner.planner.dto.ResponseDTO;
import com.planner.planner.dto.UpdateDTO;
import com.planner.planner.service.PlannerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@RestController
@Slf4j
public class PlannerController {
    @Autowired
    private PlannerService plannerService;

    @GetMapping("/goals/get")
    public List<PlanDTO> getAllPlans() {
        return plannerService.getAllPlans();
    }
    @PostMapping("/goals/post")
    public ResponseDTO registerPlan(@RequestBody @Valid PlanDTO plan) {
        log.info("planId:{}", plan.getId());
        log.info("planName:{}", plan.getTitle());
        log.info("planDescription:{}", plan.getDetail());
        log.info("planDate:{}", plan.getDate());
        boolean created = plannerService.registerPlan(plan);
        return new ResponseDTO(created ? "ok" : "fail");
    }
    @PutMapping("/goals/update")
    public ResponseDTO updatePlan(@RequestParam("id") String id, @RequestBody @Valid UpdateDTO updateDTO) {
        log.info("updatePlanId:{}", id);
        boolean updated = plannerService.updatePlan(id,updateDTO);
        return new ResponseDTO(updated ? "updated" : "not found");
    }
}
