package com.RohitBisht.Project.UberProject.UberApp.Repository;

import com.RohitBisht.Project.UberProject.UberApp.Entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Long> {
}
