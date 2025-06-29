package org.example.controller;

import org.example.InterestRateFactory;
import org.example.model.LoanInput;

public class LoanCalculator {
    public void calculate(LoanInput input) {
        double baseRate = InterestRateFactory.getBaseRate(input.getVehicleType());

        System.out.println("Hasil simulasi pinjaman:");
        for (int i = 1; i <= input.getTenor(); i++) {
            double yearlyRate = baseRate + getRateIncrement(i);
            double monthly = (input.getLoanAmount() - input.getDownPayment()) * (1 + (yearlyRate / 100)) / (input.getTenor() * 12);
            System.out.printf("Tahun %d: Rp. %.2f/bln, Suku Bunga: %.1f%%\n", i, monthly, yearlyRate);
        }
    }

    private double getRateIncrement(int year) {
        return (year / 2) * 0.5 + (year % 2) * 0.1;
    }

}
