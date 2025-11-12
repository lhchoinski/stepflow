package com.example.stepflow.entities;

import com.example.stepflow.StepNames;
import com.example.stepflow.StepStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StepNames currentStep;

    @Enumerated(EnumType.STRING)
    private StepStatus status;

    public Long getId() {
        return id;
    }

    public StepStatus getStatus() {
        return status;
    }

    public void setStatus(StepStatus status) {
        this.status = status;
    }

    public StepNames getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(StepNames currentStep) {
        this.currentStep = currentStep;
    }
}
