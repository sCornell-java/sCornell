package com.planner.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.planner.planner.entity.PlanEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity,String> {
}
