package com.RohitBisht.Project.UberProject.UberApp.Utils;

import com.RohitBisht.Project.UberProject.UberApp.DTO.PointDTO;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public class GeometryUtil {

    public static Point createPoint(PointDTO pointDTO) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        Coordinate coordinate = new Coordinate(PointDTO.getCoordinates()[0], PointDTO.getCoordinates()[1]);

        return geometryFactory.createPoint(coordinate);
    }
}
