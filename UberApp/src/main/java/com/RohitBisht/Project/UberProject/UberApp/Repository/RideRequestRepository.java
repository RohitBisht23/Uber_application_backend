package com.RohitBisht.Project.UberProject.UberApp.Repository;

import com.RohitBisht.Project.UberProject.UberApp.Entity.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
}
