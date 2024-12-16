package com.RohitBisht.Project.UberProject.UberApp.Strategies;


import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;

public interface RideFareCalculationStrategy {

    static final double RIDE_FARE_MULTIPLIER = 10;

    double CalculateFare(RideRequestEntity rideRequest);

}
