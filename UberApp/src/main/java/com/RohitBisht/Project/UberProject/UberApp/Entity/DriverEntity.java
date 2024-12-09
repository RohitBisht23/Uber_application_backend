package com.RohitBisht.Project.UberProject.UberApp.Entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Double rating;

    @Column(columnDefinition="Geometry(Point, 4326)")
    private Point currentLocation;
}
