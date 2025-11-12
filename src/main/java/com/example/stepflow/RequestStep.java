package com.example.stepflow;

import org.springframework.stereotype.Component;

@Component
public interface RequestStep {
    StepNames getStepName();
    StepResult execute(Long requestId);
}
