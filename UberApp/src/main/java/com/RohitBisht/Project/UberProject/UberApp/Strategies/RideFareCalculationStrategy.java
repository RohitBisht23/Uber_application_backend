package com.RohitBisht.Project.UberProject.UberApp.Strategies;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;

public interface RideFareCalculationStrategy {

    double CalculateFare(RideRequestEntity rideRequest);
}
