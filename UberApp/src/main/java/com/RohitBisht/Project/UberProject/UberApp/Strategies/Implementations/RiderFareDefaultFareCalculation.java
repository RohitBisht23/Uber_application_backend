package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Services.DistanceService;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.RideFareCalculationStrategy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculation implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double CalculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(), rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLIER;
    }
}
