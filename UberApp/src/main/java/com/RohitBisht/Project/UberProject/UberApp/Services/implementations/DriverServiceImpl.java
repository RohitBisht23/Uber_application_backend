package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Ride;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.DriverNotAvailableException;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.ResourceNotFoundException;
import com.RohitBisht.Project.UberProject.UberApp.Repository.DriverRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.DriverService;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideRequestService;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
        Ride ride =  rideService.createNewRide(rideRequest, savedDriver);
        return modelMapper.map(ride, RideDTO.class);
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        Ride ride = rideService.getRiderById(rideId);

        //Check if driver own the ride
        Driver driver = getCurrentDriver();

        if(!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Driver cannot start ride as he has not accepted earlier");
        }

        //Only cancel the ride when the status is confirmed
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("You cannot cancel the ongoing ride, invalid status : "+ride.getRideStatus());

        }

        ride.setRideStatus(RideStatus.CANCELLED);
        rideService.updateRideStatus(ride, RideStatus.CANCELLED);

        //Mark driver as available
        Driver savedDriver = updateDriverAvailability(driver, true);


        return modelMapper.map(ride, RideDTO.class);
    }

    @Override
    public RideDTO startRide(Long rideId, String OTP) {
        //Get the ride
        Ride ride = rideService.getRiderById(rideId);

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
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
        return modelMapper.map(savedRide, RideDTO.class);
    }

    @Override
    public RideDTO endRide(Long rideId) {

    }

    @Override
    public RideDTO rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDTO getMyProfile() {
        Driver currentDriver = getCurrentDriver();
        return modelMapper.map(currentDriver, DriverDTO.class);
    }

    @Override
    public Page<RideDTO> getAllMyRides(PageRequest pageRequest) {
        //Get current driver
        Driver currentDriver = getCurrentDriver();
        return rideService.getAllRideOfDriver(currentDriver, pageRequest)
                .map(
                        ride -> modelMapper.map(ride, RideDTO.class)
                );
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("Driver not found with id :"+2));
    }

    @Override
    public Driver updateDriverAvailability(Driver driver, boolean availability) {
        driver.setAvailable(availability);
        Driver SavedDriver = driverRepository.save(driver);
        return SavedDriver;
    }
}
