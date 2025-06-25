package com.planner.planner.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="PLAN")
public class PlanEntity {
    @Id
    private String id;
    private String title;
    private String detail;
    private String date;
}
