package com.example.stepflow;

import com.example.stepflow.entities.Request;
import com.example.stepflow.repositories.RequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.stepflow.StepStatus.PROCESSING;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RequestRepository repository;

    public DataInitializer(RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Request instance = new Request();
        instance.setCurrentStep(StepNames.FIND_FILE);
        instance.setStatus(PROCESSING);
        repository.save(instance);
    }
}
