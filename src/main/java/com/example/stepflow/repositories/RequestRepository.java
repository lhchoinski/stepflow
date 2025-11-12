package com.example.stepflow.repositories;

import com.example.stepflow.StepStatus;
import com.example.stepflow.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByStatus(StepStatus status);
}
