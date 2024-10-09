package com.csc340.mvc_second_demo.task;

import com.csc340.mvc_second_demo.goal.Goal;
import com.csc340.mvc_second_demo.goal.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    GoalService goalService;


    @PostMapping("/create/{id}")
    public String showTaskForm(@ModelAttribute("task") Task task, @PathVariable int id) {
        Goal goal = goalService.getGoalById(id);
        taskService.createNewTask(task, goal);
        return "redirect:/goals/" + id;

    }


    @PostMapping("/update")
    public String updateGoal(@RequestParam(value = "goalId", required = true) int goalId, Task task) {
        taskService.updateTask(task, goalService.getGoalById(goalId));
        return "redirect:" + task.getTaskId();
    }

    @GetMapping("/update/{taskId}")
    public String showUpdateForm(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task/task-update";
    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        int goalId = taskService.getTaskById(id).getGoal().getGoalId();
        taskService.deleteTaskById(id);
        return "redirect:/goals/" + goalId;
    }

    @GetMapping("/{id}")
    public Object getTask(@PathVariable int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("title", "Task Details:"+id);
        return "task/task-detail";
    }
}
