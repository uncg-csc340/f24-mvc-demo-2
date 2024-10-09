package com.csc340.mvc_second_demo.goal;

import com.csc340.mvc_second_demo.task.TaskService;
import com.csc340.mvc_second_demo.user.User;
import com.csc340.mvc_second_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    GoalService goalService;

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        model.addAttribute("title", "All Goals");
        return "goal/goal-list";
    }

    @GetMapping("/user/{userId}")
    public String getGoalsByUser(@PathVariable long userId,Model model) {
        model.addAttribute("goalList", goalService.getAllUserGoals(userId));
        model.addAttribute("title", "Goals for user: "+userId);
        return "goal/goal-list";
    }

    @GetMapping("/{id}")
    public String getGoalById(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        model.addAttribute("taskList", taskService.getAllTasksByGoalId(id));
        model.addAttribute("title", "Goal # "+id+" Details");
        return "goal/goal-detail";
    }

    @PostMapping("/create")
    public String createGoal(@ModelAttribute("goal") Goal goal) {
        goalService.createNewGoal(goal);
        return "redirect:/goals/all";
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Goal goal = new Goal(new User());
        //attach user list
        model.addAttribute("userList", userService.getAllUsers());
        return "goal/goal-create";
    }

    @PostMapping("/update")
    public String updateGoal(Goal goal) {
        Goal existing = goalService.getGoalById(goal.getGoalId());
        goal.setUser(existing.getUser());

        goalService.createNewGoal(goal);
        return "redirect:" + goal.getGoalId();
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal/goal-update";
    }

    @GetMapping("/delete/{id}")
    public String deleteGoalById(@PathVariable int id) {
        goalService.deleteGoal(id);
        return "redirect:/goals/all";
    }
}
