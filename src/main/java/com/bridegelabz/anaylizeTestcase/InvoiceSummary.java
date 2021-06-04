package com.bridegelabz.anaylizeTestcase;

public class InvoiceSummary
{

    private final int numOfRides;
    private final double averageFare;

    public int getNumOfRides() {
        return numOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    private final double totalFare;

    public double getAverageFare() {
        return averageFare;
    }

    public InvoiceSummary(int numOfRides, double totalFare)
    {
        this.numOfRides=numOfRides;
        this.totalFare=totalFare;
        this.averageFare=this.numOfRides/this.totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides && averageFare == that.averageFare && totalFare == that.totalFare;
    }

}
