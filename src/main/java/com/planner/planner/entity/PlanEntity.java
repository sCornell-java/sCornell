package com.planner.planner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="PLAN")
public class PlanEntity {
    @Id
    private String id;
    private String title;
    private String detail;
    private LocalDate date;
    private boolean success;
}

