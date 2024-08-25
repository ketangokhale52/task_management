package com.example.taskmanagement.taskmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; 
    private String priority; 
    private LocalDateTime dueDate;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Task(Long id, String title, String description, String status, String priority, LocalDateTime dueDate,
            LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
                + ", priority=" + priority + ", dueDate=" + dueDate + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + ", user=" + user + "]";
    }
}
