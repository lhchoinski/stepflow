package com.example.stepflow;

import com.example.stepflow.entities.Request;
import com.example.stepflow.repositories.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.stepflow.StepStatus.PROCESSING;


@Component
public class WorkflowScheduler {

    private final RequestRepository repository;
    private final WorkflowExecutor executor;

    public WorkflowScheduler(RequestRepository repository, WorkflowExecutor executor) {
        this.repository = repository;
        this.executor = executor;
    }

    @Scheduled(fixedRate = 5000)
    @Transactional
    public void processPendingWorkflows() {
        List<Request> requests = repository.findByStatus(PROCESSING);

        requests.forEach(request -> {
            StepResult result = executor.executeStep(request);

            request.setCurrentStep(result.getNextStep());
            repository.save(request);
        });
    }
}