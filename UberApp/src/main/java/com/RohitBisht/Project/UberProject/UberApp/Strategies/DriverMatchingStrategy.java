package com.RohitBisht.Project.UberProject.UberApp.Strategies;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.DriverEntity;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;

import java.util.List;

public interface DriverMatchingStrategy {

    List<DriverEntity> findMatchingDriver(RideRequestEntity rideRequest);
}
