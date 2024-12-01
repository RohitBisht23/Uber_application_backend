package com.RohitBisht.Project.UberProject.UberApp.Entity;

import jakarta.persistence.*;

@Entity
public class RiderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Double rating;
}
