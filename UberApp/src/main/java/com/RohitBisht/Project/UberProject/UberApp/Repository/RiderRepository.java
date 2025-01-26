package com.RohitBisht.Project.UberProject.UberApp.Repository;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
