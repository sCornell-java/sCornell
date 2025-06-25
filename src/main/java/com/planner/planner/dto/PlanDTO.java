package com.planner.planner.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO {
    private String id;
    private String title;
    private String detail;
    private String date;
}
