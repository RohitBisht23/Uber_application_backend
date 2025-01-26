package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideEntity;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {

    @Override
    public RideEntity getRiderById(Long rideID) {
        return null;
    }

    @Override
    public void matchWithDriver(RideRequestDTO rideRequestDTO) {

    }

    @Override
    public RideEntity createNewRide(RideRequestDTO rideRequestDTO, Driver driver) {
        return null;
    }

    @Override
    public RideEntity updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<RideEntity> getAllRideOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<RideEntity> getAllRideOfDriver(Long riderId, PageRequest pageRequest) {
        return null;
    }
}
