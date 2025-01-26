package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.RideFareCalculationStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RiderFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {


    @Override
    public double CalculateFare(RideRequest rideRequest) {
        return 0;
    }
}
