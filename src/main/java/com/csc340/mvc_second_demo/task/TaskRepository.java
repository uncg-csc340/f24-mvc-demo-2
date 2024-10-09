package com.csc340.mvc_second_demo.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "select * from tasks where goal_id = :goalId", nativeQuery = true)
    public List<Task> getTasksByGoalId(@Param("goalId") int goalId);
}
