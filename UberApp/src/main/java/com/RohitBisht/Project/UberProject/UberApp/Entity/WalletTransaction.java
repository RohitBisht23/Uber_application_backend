package com.RohitBisht.Project.UberProject.UberApp.Entity;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.TransactionMethods;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethods transactionMethods;

    @OneToOne
    private Ride ride;

    public String TransactionId;

    @CreationTimestamp
    private LocalDateTime timeStamp;

    @ManyToOne
    private Waller wallet;
}
