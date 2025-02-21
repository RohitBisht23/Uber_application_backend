package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;


import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.ResourceNotFoundException;
import com.RohitBisht.Project.UberProject.UberApp.Repository.RideRequestRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Ride request not found with id "+ rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        RideRequest tosave = rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Ride Request not found with id :"+rideRequest.getId())
                );
        rideRequestRepository.save(tosave);

    }
}
