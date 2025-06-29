package org.example.controller;


import org.example.model.LoanInput;
import org.junit.Test;

public class LoanCalculatorTest {
    @Test
    public void calculate() {
        LoanInput input = new LoanInput("Mobil", "Baru", 2024, 100_000_000, 3, 35_000_000);
        LoanCalculator calc = new LoanCalculator();
        calc.calculate(input);
    }
}