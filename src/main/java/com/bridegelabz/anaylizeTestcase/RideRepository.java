package com.bridegelabz.anaylizeTestcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository
{
    Map<String,ArrayList<Ride>> userlist;

    public RideRepository()
    {
        userlist=new HashMap<>();
    }

    public void add(String user_id, Ride[] ride)
    {
            ArrayList<Ride> rideList=this.userlist.get(user_id);
            if(rideList==null)
            {
                userlist.put(user_id, new ArrayList<>(Arrays.asList(ride)));
            }
    }
    public Ride[] getRides(String userId) {
        return this.userlist.get(userId).toArray(new Ride[0]);

    }
}
