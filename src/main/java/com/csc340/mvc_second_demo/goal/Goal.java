package com.csc340.mvc_second_demo.goal;

import com.csc340.mvc_second_demo.constants.Status;
import com.csc340.mvc_second_demo.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Date;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goalId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private String title;

    private String details;

    @Column(nullable = false)
    private Date targetDate;

    @Column(nullable = false)
    private Status status;

    public Goal() {
    }

    public Goal(User user) {
        this.user=new User();
    }

    public Goal(int goalId, User user, @NonNull String title, String details, @NonNull Date targetDate, @NonNull Status status) {
        this.goalId = goalId;
        this.user = user;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Goal(User user, @NonNull String title, String details, @NonNull Date targetDate) {
        this.user = user;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = Status.Pending;
    }

    public Goal(Goal goal) {
        this.goalId = goal.getGoalId();
        this.user = goal.getUser();
        this.title = goal.getTitle();
        this.details = goal.getDetails();
        this.targetDate = goal.getTargetDate();
        this.status = goal.getStatus();
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int id) {
        this.goalId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @NonNull
    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(@NonNull Date targetDate) {
        this.targetDate = targetDate;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    public void setStatus(@NonNull Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", targetDate=" + targetDate +
                ", status=" + status +
                '}';
    }
}
