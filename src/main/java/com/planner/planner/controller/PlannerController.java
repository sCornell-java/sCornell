package com.planner.planner.controller;

import com.planner.planner.dto.ResponseDTO;
import com.planner.planner.service.PlannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PlannerController {
    @Autowired
    private PlannerService plannerService;

    @DeleteMapping("goals/delete")
    public ResponseDTO deletePlan(@RequestParam("id") String id) {
        log.info("deletePlan:{}", id);
        boolean delete = plannerService.deletePlan(id);
        return new ResponseDTO(delete ? "삭제되었습니다." : "없는 계획이거나 삭제된 계획입니다.");
    }
}
