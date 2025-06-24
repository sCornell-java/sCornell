package com.planner.planner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO {
    private String id;
    private String title;
    private String detail;
    private LocalDate date;
    private boolean success;
}
