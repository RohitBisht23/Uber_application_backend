package com.RohitBisht.Project.UberProject.UberApp.Repository;


import com.RohitBisht.Project.UberProject.UberApp.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
