package com.planner.planner.repository;

import com.planner.planner.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends CrudRepository<PlanEntity, String> {
}
