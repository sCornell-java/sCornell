package com.planner.planner.controller;

import com.planner.planner.dto.ResponseDTO;
import com.planner.planner.dto.SuccessRequestDTO;
import com.planner.planner.service.PlannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PlannerController {
    private final PlannerService plannerService;

    public PlannerController(PlannerService plannerService) {
        this.plannerService = plannerService;
    }

    @DeleteMapping("/goals/delete")
    public ResponseDTO deletePlan(@RequestParam("id") String id) {
        log.info("deletePlanId: {}", id);
        boolean delete = plannerService.deletePlan(id);
        return new ResponseDTO(delete ? "삭제되었습니다." : "없는 계획이거나 삭제된 계획입니다.");
    }

    @PutMapping("/goals/success")
    public ResponseDTO success(@RequestBody SuccessRequestDTO successRequestDTO) {
        log.info("success: {}", successRequestDTO);
        boolean updated = plannerService.changeResultPlan(successRequestDTO);
        return new ResponseDTO(updated ? "달성 여부가 변경되었습니다." : "달성 여부 변경에 실패하였습니다.");
    }
}