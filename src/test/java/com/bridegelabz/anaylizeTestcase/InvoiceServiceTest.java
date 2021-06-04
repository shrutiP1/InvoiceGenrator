package com.bridegelabz.anaylizeTestcase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest
{
    InvoiceGenerator invoiceGenerator=null;
    @BeforeEach
    public void setUp()
    {
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_WhenCalculated_ShouldReturnFare()
    {
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25,fare);
    }
    @Test
    public void givenLessDistanceOrTime_ShouldResturnMinFare()
    {
        double distance=0.1;
        int time=1;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5.0,fare,0.0);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        Ride[] rides={
                new Ride(2.0, 5, PremiumRides.NORMAL),
                new Ride(0.1,1, PremiumRides.NORMAL),

        };
        InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30);
        Assertions.assertEquals(expectedInvoiceSummary,summary);

    }
    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary()
    {
        String user_id="shruti";
        Ride[] ride={
                new Ride(2.0,5, PremiumRides.NORMAL),
                new Ride(0.1,1, PremiumRides.NORMAL),
                new Ride(2,2, PremiumRides.NORMAL),
        };
        invoiceGenerator.addRides(user_id,ride);
        InvoiceSummary summary=invoiceGenerator.getInvoicesummary(user_id);
        InvoiceSummary expectedsummary=new InvoiceSummary(3,52);
        Assertions.assertEquals(expectedsummary,summary);
    }
    @Test
    public void givenUserIdAndTypes_shouldReturnInvoiceSummary()
    {
        String userId = "Bhushan";
        Ride[] rides = {
                new Ride(2.0, 5, PremiumRides.NORMAL),
                new Ride(0.1, 1, PremiumRides.PREMIUM),
                new Ride(2, 2, PremiumRides.PREMIUM)
        };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoicesummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 79);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }




}
