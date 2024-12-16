package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RideRequestDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.RiderDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequestEntity;
import com.RohitBisht.Project.UberProject.UberApp.Repository.RideRequestRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.RiderService;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.DriverMatchingStrategy;
import com.RohitBisht.Project.UberProject.UberApp.Strategies.RideFareCalculationStrategy;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private  final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {

        RideRequestEntity rideRequest = modelMapper.map(rideRequestDTO, RideRequestEntity.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        //Calculating fare
        Double fare = rideFareCalculationStrategy.CalculateFare(rideRequest);

        rideRequest.setFare(fare);

        RideRequestEntity savedRideRequest = rideRequestRepository.save(rideRequest);

        //Matching Drivers
        driverMatchingStrategy.findMatchingDrivers(rideRequest);

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
}
