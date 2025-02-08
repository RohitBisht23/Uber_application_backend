package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.Services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {

        RestClient restClient = RestClient.builder()
                .baseUrl(OSRM_API_BASE_URL)
                .build()
                .get()
                .uri("{},{};{},{}", src.getX(), src.getY(), dest.getX(), dest.getY())
                .retrieve()
                .body()

        return 0;
    }
}
