package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class DriverMatchingNearestHighestRatedDriverStrategy implements DriverMatchingStrategy {

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return List.of();
    }
}