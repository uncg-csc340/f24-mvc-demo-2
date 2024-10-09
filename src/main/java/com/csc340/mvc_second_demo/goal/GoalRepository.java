package com.csc340.mvc_second_demo.goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    @Query(value = "select * from goals where user_id = :userId", nativeQuery = true)
    public List<Goal> getUserGoals(@Param("userId") long userId);
}
