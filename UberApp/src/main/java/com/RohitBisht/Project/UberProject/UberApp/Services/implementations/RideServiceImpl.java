package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideEntity;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.ResourceNotFoundException;
import com.RohitBisht.Project.UberProject.UberApp.Repository.RideRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideRequestService;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;
    private final ModelMapper modelMapper;

    @Override
    public RideEntity getRiderById(Long rideID) {
        RideEntity ride = rideRepository.findById(rideID)
                .orElseThrow(()-> new ResourceNotFoundException("Ride does not exist with id :"+rideID));
        return ride;
    }


    @Override
    public RideEntity createNewRide(RideRequest rideRequest, Driver driver) {
        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);

        RideEntity ride = modelMapper.map(rideRequest, RideEntity.class);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setDriver(driver);
        ride.setOtp(generateRandomORP());
        ride.setId(null);

        rideRequestService.update(rideRequest);
        return rideRepository.save(ride);
    }

    @Override
    public RideEntity updateRideStatus(RideEntity ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        RideEntity savedRide = rideRepository.save(ride);
        return savedRide;
    }

    @Override
    public Page<RideEntity> getAllRideOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<RideEntity> getAllRideOfDriver(Long riderId, PageRequest pageRequest) {
        return null;
    }


    private String generateRandomORP() {
        Random random = new Random();
        int otpInt = random.nextInt(10000);  //0-9999
        return String.format("%04d", otpInt);
    }
}
