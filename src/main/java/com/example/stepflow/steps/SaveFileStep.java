package com.example.stepflow.steps;

import com.example.stepflow.RequestStep;
import com.example.stepflow.StepNames;
import com.example.stepflow.StepResult;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SaveFileStep implements RequestStep {

    @Override
    public StepNames getStepName() {
        return StepNames.SAVE_FILE;
    }

    @Override
    public StepResult execute(Long requestId) {
        System.out.println("💾 Salvando arquivo...");
        boolean success = new Random().nextBoolean();

        if (!success) {
            System.out.println("⚠️ Falha ao salvar, voltando para FIND_FILE");
            return StepResult.retry(StepNames.FIND_FILE);
        }
        return StepResult.next(StepNames.NOTIFY_USER);
    }
}


