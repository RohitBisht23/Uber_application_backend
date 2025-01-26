package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Repository.DriverRepository;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.DriverMatchingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findNearestDrivers(rideRequest.getPickUpLocation());
    }
}
