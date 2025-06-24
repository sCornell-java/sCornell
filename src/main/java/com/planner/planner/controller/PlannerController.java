package com.planner.planner.controller;

import com.planner.planner.service.PlannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PlannerController {
    @Autowired
    private PlannerService plannerService;
}
