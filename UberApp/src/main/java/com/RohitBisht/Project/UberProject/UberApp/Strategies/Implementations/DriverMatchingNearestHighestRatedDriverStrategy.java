package com.RohitBisht.Project.UberProject.UberApp.Strategies.Implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.DriverEntity;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingNearestHighestRatedDriverStrategy implements DriverMatchingStrategy {

    @Override
    public List<DriverEntity> findMatchingDriver(RideRequestEntity rideRequestDTO) {
        return List.of();
    }
}
