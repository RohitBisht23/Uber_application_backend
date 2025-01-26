package com.RohitBisht.Project.UberProject.UberApp.Services;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public interface RideService {
    RideEntity getRiderById(Long rideID);

    void matchWithDriver(RideRequestDTO rideRequestDTO);

    RideEntity createNewRide(RideRequestDTO rideRequestDTO, Driver driver);

    RideEntity updateRideStatus(Long rideId, RideStatus rideStatus);

    Page<RideEntity> getAllRideOfRider(Long riderId, PageRequest pageRequest);

    Page<RideEntity> getAllRideOfDriver(Long riderId, PageRequest pageRequest);
}
