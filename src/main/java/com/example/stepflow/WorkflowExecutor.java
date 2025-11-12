package com.example.stepflow;

import com.example.stepflow.entities.Request;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WorkflowExecutor {

    private final Map<StepNames, RequestStep> steps;

    public WorkflowExecutor(List<RequestStep> stepList) {
        this.steps = stepList.stream()
                .collect(Collectors.toMap(RequestStep::getStepName, s -> s));
    }

    public StepResult executeStep(Request request) {
        RequestStep step = steps.get(request.getCurrentStep());

        if (step == null) {
            throw new IllegalStateException("Step não encontrado: " + request.getCurrentStep());
        }
        return step.execute(request.getId());
    }
}


