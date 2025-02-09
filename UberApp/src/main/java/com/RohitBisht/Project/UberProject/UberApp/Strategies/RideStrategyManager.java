package com.RohitBisht.Project.UberProject.UberApp.Strategies;


import com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations.DriverMatchingNearestDriverStrategy;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations.DriverMatchingNearestHighestRatedDriverStrategy;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations.RiderFareDefaultFareCalculation;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations.RiderFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final DriverMatchingNearestHighestRatedDriverStrategy driverMatchingNearestHighestRatedDriverStrategy;

    private final RiderFareDefaultFareCalculation riderDefaultFareCalculation;
    private final RiderFareSurgePricingFareCalculationStrategy riderFareSurgePricingFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        //If rider rating more than equals to 4.0 it will return highest reting driver list
        if(riderRating >= 4.0) {
            return driverMatchingNearestHighestRatedDriverStrategy;
        } else {
            return driverMatchingNearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy() {
        // Peek hour - 6PM - 11PM
        LocalTime SurgeStartTime = LocalTime.of(18, 0);
        LocalTime SurgeEndTime = LocalTime.of(22, 59);

        //Current ride making time
        LocalTime currentTime = LocalTime.now();

        //If current time lies in peek time
        boolean isSurge = currentTime.isAfter(SurgeStartTime) && currentTime.isBefore(SurgeEndTime);

        if(isSurge) {
            return riderFareSurgePricingFareCalculationStrategy;
        } else {
            return riderDefaultFareCalculation;
        }
    }

}
