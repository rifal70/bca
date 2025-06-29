package org.example.model;

public class LoanInput {
    private String vehicleType;
    private String condition;
    private int year;
    private long loanAmount;
    private int tenor;
    private long downPayment;

    public LoanInput(String vehicleType, String condition, int year, long loanAmount, int tenor, long downPayment) {
        this.vehicleType = vehicleType.toLowerCase();
        this.condition = condition.toLowerCase();
        this.year = year;
        this.loanAmount = loanAmount;
        this.tenor = tenor;
        this.downPayment = downPayment;
    }

    public String getVehicleType() { return vehicleType; }
    public String getCondition() { return condition; }
    public int getYear() { return year; }
    public long getLoanAmount() { return loanAmount; }
    public int getTenor() { return tenor; }
    public long getDownPayment() { return downPayment; }
}
