package com.RohitBisht.Project.UberProject.UberApp.DTO;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.PaymentMethod;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
public class RideDTO {

    private Long id;


    private PointDTO pickUpLocation;


    private PointDTO dropOffLocation;


    private LocalDateTime createdTime;


    private RiderDTO rider;


    private DriverDTO driver;


    private PaymentMethod paymentMethod;


    private RideStatus rideStatus;

    private String otp;

    private Double fare;

    private LocalDateTime startAt;

    private LocalDateTime endAt;
}
