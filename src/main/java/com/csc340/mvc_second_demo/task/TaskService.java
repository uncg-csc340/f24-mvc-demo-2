package com.csc340.mvc_second_demo.task;

import com.csc340.mvc_second_demo.goal.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void createNewTask(Task task, Goal goal) {
        task = new Task(task.getTitle(), task.getDetails(), goal);
        taskRepository.save(task);
    }

    public void updateTask(Task task, Goal goal) {
        task = new Task(task, goal);
        taskRepository.save(task);
    }

    public List<Task> getAllTasksByGoalId(int id) {
        return taskRepository.getTasksByGoalId(id);
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

    public void deleteTasksByGoalId(int id) {
        List<Task> tasks = taskRepository.getTasksByGoalId(id);
        taskRepository.deleteAll(tasks);
    }
}
