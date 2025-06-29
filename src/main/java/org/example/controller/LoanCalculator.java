package org.example.controller;

import org.example.InterestRateFactory;
import org.example.model.LoanInput;

public class LoanCalculator {
    public void calculate(LoanInput input) {
        validateDownPayment(input);
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

    private void validateDownPayment(LoanInput input) {
        if (input.getCondition().equalsIgnoreCase("baru")) {
            double minPercent = input.getVehicleType().equalsIgnoreCase("mobil") ? 0.35 : 0.25;
            long minDP = (long) (minPercent * input.getLoanAmount());

            if (input.getDownPayment() < minDP) {
                throw new IllegalArgumentException(String.format(
                        "DP minimal untuk %s baru adalah %.0f%% dari jumlah pinjaman (Minimal: Rp %,d). Inputan Anda: Rp %,d",
                        input.getVehicleType(),
                        minPercent * 100,
                        minDP,
                        input.getDownPayment()
                ));
            }
        }
    }

}
