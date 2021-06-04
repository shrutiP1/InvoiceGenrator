package com.bridegelabz.anaylizeTestcase;

public class InvoiceGenerator {

    private static final int FARE_FOR_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private double FARE_PER_DIstance = 10;
    RideRepository rideRepository=new RideRepository();
    public double calculateFare(double distance, int time) {
        double totalDistance = distance * FARE_PER_DIstance + time * FARE_FOR_TIME;
        return Math.max(totalDistance,MINIMUM_FARE);
    }
    public InvoiceSummary calculateFare(Ride[] rides)
    {
        double totalFare=0.0;
        for(Ride ride:rides)
        {
            double fare=ride.cabRide.calculateCostOfCabRide(ride);
            totalFare+=fare;
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String user_id, Ride[] ride)
    {
        System.out.println(user_id);
        rideRepository.add(user_id,ride);
    }

    public InvoiceSummary getInvoicesummary(String user_id)
    {
        return this.calculateFare(rideRepository.getRides(user_id));
    }
}