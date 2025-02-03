package com.RohitBisht.Project.UberProject.UberApp.Entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

    private Boolean available;

    private String vehicleId;

    @Column(columnDefinition="Geometry(Point, 4326)")
    private Point currentLocation;
}
