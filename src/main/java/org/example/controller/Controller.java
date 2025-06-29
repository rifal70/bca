package org.example.controller;

import org.example.model.LoanInput;
import org.example.service.InputService;

public class Controller {
    private final LoanCalculator calculator = new LoanCalculator();
    private final InputService inputService = new InputService();

    public void runInteractive() {
        LoanInput input = inputService.getFromConsole();
        calculator.calculate(input);
    }

    public void runWithFile(String filename) {
        LoanInput input = inputService.getFromFile(filename);
        calculator.calculate(input);
    }
}