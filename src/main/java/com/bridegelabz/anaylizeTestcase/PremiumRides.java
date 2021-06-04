package com.bridegelabz.anaylizeTestcase;

public enum PremiumRides
{
    NORMAL(10.0, 1.0, 5.0),
    PREMIUM(15.0, 2.0, 20.0);

    private final double costPerKm;
    private final double costPerMin;
    private final double minFarePerRide;

    PremiumRides(double costPerKm, double costPerMin, double minFarePerRide) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minFarePerRide = minFarePerRide;
    }
    public double calculateCostOfCabRide(Ride ride) {
        double rideCost = ride.getDistance() * costPerKm + ride.getTime() * costPerMin;
        return Math.max(rideCost, minFarePerRide);
    }

}
