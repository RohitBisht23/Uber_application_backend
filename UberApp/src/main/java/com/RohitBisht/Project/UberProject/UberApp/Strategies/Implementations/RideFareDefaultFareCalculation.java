package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;
import com.RohitBisht.Project.UberProject.UberApp.Services.DistanceService;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.RideFareCalculationStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RideFareDefaultFareCalculation implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double CalculateFare(RideRequestEntity rideRequest) {
        double distnace = distanceService.calculateDistance(rideRequest.get, rideRequest.getDropOffLocation());
        return 0;
    }
}
