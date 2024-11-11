package com.RohitBisht.Project.UberProject.UberApp.Entity;

import jakarta.persistence.*;

@Entity
public class WallerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private Double balance;

}
