package com.bridegelabz.anaylizeTestcase;

public class Ride {
    public PremiumRides cabRide;


    public PremiumRides getCabRide() {
        return cabRide;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    private final double distance;
    private final int time;

    public Ride(double distance, int time, PremiumRides premiumRides)
    {
        this.distance=distance;
        this.time=time;
        this.cabRide=premiumRides;

    }
}
