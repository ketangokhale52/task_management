package com.example.taskmanagement.taskmanagement.specification;

import com.example.taskmanagement.taskmanagement.model.Task;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {
    public static Specification<Task> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Task> hasPriority(String priority) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> dueBefore(LocalDateTime dueDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("dueDate"), dueDate);
    }
}
