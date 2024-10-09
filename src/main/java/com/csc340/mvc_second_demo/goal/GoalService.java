package com.csc340.mvc_second_demo.goal;


import com.csc340.mvc_second_demo.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    @Autowired
    TaskService taskService;

    public Object getAllGoals() {
        // Using a static userId since we are the only user
        return goalRepository.findAll();
    }

    public void createNewGoal(Goal goal) {
        if (goalRepository.existsById(goal.getGoalId())) {
            goal = new Goal(goal);
            goalRepository.save(goal);
            return;
        }
        goal = new Goal(goal.getUser(), goal.getTitle(), goal.getDetails(), goal.getTargetDate());
        goalRepository.save(goal);
    }

    public void deleteGoal(int id) {
        taskService.deleteTasksByGoalId(id);
        goalRepository.deleteById(id);
    }

    public Object getAllUserGoals(long userId) {
        // Using a static userId since we are the only user
        return goalRepository.getUserGoals(userId);
    }

    public Goal getGoalById(int id) {
        return goalRepository.findById(id).orElse(null);
    }
}
