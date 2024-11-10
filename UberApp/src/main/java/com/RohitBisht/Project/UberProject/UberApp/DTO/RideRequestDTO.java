package com.RohitBisht.Project.UberProject.UberApp.DTO;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.PaymentMethod;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.RideRequestStatus;
import com.RohitBisht.Project.UberProject.UberApp.Entity.RiderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDTO {

    private Long id;


    private Point pickUpLocation;

    private Point dropOffLocation;


    private LocalDateTime requestTime;


    private PaymentMethod paymentMethod;


    private RideRequestStatus rideRequestStatus;
}
