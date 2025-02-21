package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RiderDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Driver;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Rider;
import com.RohitBisht.Project.UberProject.UberApp.Entity.User;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.ResourceNotFoundException;
import com.RohitBisht.Project.UberProject.UberApp.Repository.RideRequestRepository;
import com.RohitBisht.Project.UberProject.UberApp.Repository.RiderRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.RiderService;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    public final RiderRepository riderRepository;

    @Override
    @Transactional
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {

        Rider rider = getCurrentRider();

        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);

        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        //Setting the rider to ride request
        rideRequest.setRider(rider);

        //Calculating fare
        Double fare = rideStrategyManager.rideFareCalculationStrategy().CalculateFare(rideRequest);

        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        //Matching Drivers
        List<Driver> drivers = rideStrategyManager
                .driverMatchingStrategy(rider.getRating())
                .findMatchingDrivers(rideRequest);

        // TODO notify all the drivers by sending notification about this ride

        return modelMapper.map(savedRideRequest, RideRequestDTO.class);
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider newRider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        riderRepository.save(newRider);

        return newRider;
    }



    //Temparary method to get rider data, final will be getting rider from spring security
    @Override
    public Rider getCurrentRider() {
        //TODO : implement spring security
        return riderRepository.findById(1L).orElseThrow(()->new ResourceNotFoundException("Rider not found with id : "+1));
    }
}
