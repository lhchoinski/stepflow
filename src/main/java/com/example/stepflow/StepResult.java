package com.example.stepflow;

public class StepResult {
    private final boolean success;
    private final StepNames nextStep;

    private StepResult(boolean success, StepNames nextStep) {
        this.success = success;
        this.nextStep = nextStep;
    }

    public static StepResult next(StepNames next) {
        return new StepResult(true, next);
    }

    public static StepResult retry(StepNames retryStep) {
        return new StepResult(false, retryStep);
    }

    public boolean isSuccess() {
        return success;
    }

    public StepNames getNextStep() {
        return nextStep;
    }
}
