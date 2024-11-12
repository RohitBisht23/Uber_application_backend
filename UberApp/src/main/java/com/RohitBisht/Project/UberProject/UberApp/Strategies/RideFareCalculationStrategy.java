package com.RohitBisht.Project.UberProject.UberApp.Strategies;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;

public interface RideFareCalculationStrategy {

    double CalculateFare(RideRequestDTO rideRequestDTO);
}
