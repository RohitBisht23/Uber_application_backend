package com.RohitBisht.Project.UberProject.UberApp.Services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    double calculateDistance(Point src, Point dest);
}
