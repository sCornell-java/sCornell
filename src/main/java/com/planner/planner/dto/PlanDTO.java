package com.planner.planner.dto;

import lombok.*;
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
