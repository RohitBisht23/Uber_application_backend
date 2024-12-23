package com.RohitBisht.Project.UberProject.UberApp.Strategies;


import com.RohitBisht.Project.UberProject.UberApp.Entity.DriverEntity;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;

import java.util.List;

public interface DriverMatchingStrategy {

    List<DriverEntity> findMatchingDrivers(RideRequestEntity rideRequest);

}
