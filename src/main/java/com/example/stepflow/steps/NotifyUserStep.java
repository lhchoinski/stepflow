package com.example.stepflow.steps;

import com.example.stepflow.RequestStep;
import com.example.stepflow.StepNames;
import com.example.stepflow.StepResult;
import com.example.stepflow.StepStatus;
import com.example.stepflow.entities.Request;
import com.example.stepflow.repositories.RequestRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NotifyUserStep implements RequestStep {

    @Override
    public StepNames getStepName() {
        return StepNames.NOTIFY_USER;
    }

    @Override
    public StepResult execute(Long requestId) {
        System.out.println("📢 Notificando usuário...");
        Optional<Request> request = repository.findById(requestId);

        request.ifPresent(request1 -> {
            System.out.println("Atualizando status...");
            request1.setStatus(StepStatus.COMPLETED);
        });

        return StepResult.next(null);
    }

    @Resource
    RequestRepository repository;
}