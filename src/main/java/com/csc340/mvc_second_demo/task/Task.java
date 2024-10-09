package com.csc340.mvc_second_demo.task;

import com.csc340.mvc_second_demo.constants.Status;
import com.csc340.mvc_second_demo.goal.Goal;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goalId")
    private Goal goal;

    @Nonnull
    private String title;

    private String details;

    @Nonnull
    private Status status;

    public Task() {
    }

    public Task(int taskId, Goal goal, @Nonnull String title, String details, @Nonnull Status status) {
        this.taskId = taskId;
        this.goal = goal;
        this.title = title;
        this.details = details;
        this.status = status;
    }

    public Task(Task task, Goal goal) {
        this.taskId = task.getTaskId();
        this.goal = goal;
        this.title = task.getTitle();
        this.details = task.getDetails();
        this.status = task.getStatus();
    }

    public Task(@Nonnull String title, String details, @Nonnull Goal goal) {
        this.goal = goal;
        this.title = title;
        this.details = details;
        this.status = Status.Pending;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Nonnull
    public Status getStatus() {
        return status;
    }

    public void setStatus(@Nonnull Status status) {
        this.status = status;
    }
}
