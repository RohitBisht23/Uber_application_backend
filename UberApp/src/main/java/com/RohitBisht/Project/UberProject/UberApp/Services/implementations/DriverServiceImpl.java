package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideStartDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideEntity;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.DriverNotAvailableException;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.ResourceNotFoundException;
import com.RohitBisht.Project.UberProject.UberApp.Repository.DriverRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.DriverService;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideRequestService;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RideDTO acceptRide(Long rideRequestId) {
        //Get the ride to check if it is accepted
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
            throw new RuntimeException("RideRequest cannot be accepted, status is "+rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();

        //Check if driver itself available or not
        if(!currentDriver.getAvailable()) {
            throw new DriverNotAvailableException("Driver cannot accept ride due to unavailability.");
        }

        //Mark driver as unavailable
        currentDriver.setAvailable(false);
        Driver savedDriver = driverRepository.save(currentDriver);

        //Create new Ride
        RideEntity ride =  rideService.createNewRide(rideRequest, savedDriver);
        return modelMapper.map(ride, RideDTO.class);
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO startRide(Long rideId, String OTP) {
        //Get the ride
        RideEntity ride = rideService.getRiderById(rideId);

        //Check if this driver own this ride then only start the ride
        Driver driver = getCurrentDriver();

        if(!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Driver cannot start ride as he has not accepted earlier");
        }

        //Check status
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride status is not confirmed hence cannot be started, status :"+ride.getRideStatus());
        }

        //check otp
        if(!OTP.equals(ride.getOtp())) {
            throw  new RuntimeException("OTP is not valid. OTP : "+OTP);
        }
        ride.setStartAt(LocalDateTime.now());  //set started ride time
        RideEntity savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
        return modelMapper.map(savedRide, RideDTO.class);
    }

    @Override
    public RideDTO endRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return List.of();
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("Driver not found with id :"+2));
    }
}
