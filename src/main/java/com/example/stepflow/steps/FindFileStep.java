package com.example.stepflow.steps;

import com.example.stepflow.RequestStep;
import com.example.stepflow.StepNames;
import com.example.stepflow.StepResult;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FindFileStep implements RequestStep {

    @Override
    public StepNames getStepName() {
        return StepNames.FIND_FILE;
    }

    @Override
    public StepResult execute(Long requestId) {
        System.out.println("🔍 Procurando arquivo...");
        boolean found = new Random().nextBoolean();
        if (!found) {
            System.out.println("❌ Arquivo não encontrado, recomeçando...");
            return StepResult.retry(StepNames.FIND_FILE);
        }
        return StepResult.next(StepNames.SAVE_FILE);
    }
}

