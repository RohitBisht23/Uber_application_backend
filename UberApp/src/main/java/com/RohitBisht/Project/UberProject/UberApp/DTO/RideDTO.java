package com.RohitBisht.Project.UberProject.UberApp.DTO;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.PaymentMethod;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideStatus;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDTO {

    private Long id;


    private Point pickUpLocation;


    private Point dropOffLocation;


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
