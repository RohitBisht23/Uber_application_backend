package com.RohitBisht.Project.UberProject.UberApp.Strategies;


import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double CalculateFare(RideRequest rideRequest);

}
