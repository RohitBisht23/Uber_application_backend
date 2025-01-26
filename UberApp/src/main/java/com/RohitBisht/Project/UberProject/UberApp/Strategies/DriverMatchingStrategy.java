package com.RohitBisht.Project.UberProject.UberApp.Strategies;


import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDrivers(RideRequest rideRequest);

}
