package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.Services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
    //TODO    //Call the third party api call OSMR to fetch the distance
        return 0;
    }
}
