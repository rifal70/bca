package org.example;

public class InterestRateFactory {
    public static double getBaseRate(String vehicleType) {
        switch(vehicleType.toLowerCase()) {
            case "mobil": return 8.0;
            case "motor": return 9.0;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
