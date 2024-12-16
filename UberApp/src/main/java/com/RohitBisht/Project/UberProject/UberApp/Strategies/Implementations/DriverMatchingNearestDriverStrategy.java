package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.DriverEntity;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;
import com.RohitBisht.Project.UberProject.UberApp.Repository.DriverRepository;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.DriverMatchingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<DriverEntity> findMatchingDrivers(RideRequestEntity rideRequest) {
        return driverRepository.findMatchingDrivers(rideRequest.getPickUpLocation());
    }
}
