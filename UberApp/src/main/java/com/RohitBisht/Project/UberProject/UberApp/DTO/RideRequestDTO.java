package com.RohitBisht.Project.UberProject.UberApp.DTO;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.PaymentMethod;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDTO {

    private Long id;


    private PointDTO pickUpLocation;
    private PointDTO dropOffLocation;
    private PaymentMethod paymentMethod;

    private LocalDateTime requestTime;

    private RiderDTO rider;

    private RideRequestStatus rideRequestStatus;

    private Double fare;
}
