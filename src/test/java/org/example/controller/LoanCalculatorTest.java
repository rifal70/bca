package org.example.controller;

import org.example.model.LoanInput;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LoanCalculatorTest {
    @Test
    public void calculate() {
        LoanInput input = new LoanInput("Mobil", "Baru", 2024, 100_000_000, 3, 35_000_000);
        LoanCalculator calc = new LoanCalculator();
        calc.calculate(input);
    }

    @Test
    public void testMobilBaru_DPLessThan35Percent_ShouldThrow() {
        LoanInput input = new LoanInput("Mobil", "Baru", 2024, 100_000_000, 3, 20_000_000);
        LoanCalculator calc = new LoanCalculator();

        try {
            calc.calculate(input);
            fail("Expected IllegalArgumentException for DP < 35%");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("DP minimal untuk mobil baru"));
            System.out.print("DP minimal untuk mobil baru");
        }
    }

    @Test
    public void testMotorBaru_DPLessThan25Percent_ShouldThrow() {
        LoanInput input = new LoanInput("Motor", "Baru", 2024, 50_000_000, 2, 10_000_000);
        LoanCalculator calc = new LoanCalculator();

        try {
            calc.calculate(input);
            fail("Expected IllegalArgumentException for DP < 25%");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("DP minimal untuk motor baru"));
            System.out.print("DP minimal untuk motor baru");
        }
    }

    @Test
    public void testMobilBekas_AnyDP_ShouldPass() {
        LoanInput input = new LoanInput("Mobil", "Bekas", 2019, 100_000_000, 2, 5_000_000);
        LoanCalculator calc = new LoanCalculator();

        try {
            calc.calculate(input); // should not throw
        } catch (Exception ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    public void testMotorBekas_AnyDP_ShouldPass() {
        LoanInput input = new LoanInput("Motor", "Bekas", 2019, 50_000_000, 3, 1_000_000);
        LoanCalculator calc = new LoanCalculator();

        try {
            calc.calculate(input); // should not throw
        } catch (Exception ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    public void testValidMobilBaru_ShouldCalculateNormally() {
        LoanInput input = new LoanInput("Mobil", "Baru", 2024, 100_000_000, 3, 35_000_000);
        LoanCalculator calc = new LoanCalculator();

        try {
            calc.calculate(input); // should not throw
        } catch (Exception ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }
}