package com.RohitBisht.Project.UberProject.UberApp.Configs;

import com.RohitBisht.Project.UberProject.UberApp.DTO.PointDTO;
import com.RohitBisht.Project.UberProject.UberApp.Utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration  // Add this annotation
public class ModelConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();


        //Converts the PointDTO to Point
        mapper.typeMap(PointDTO.class, Point.class)
                .setConverter(context -> {
                PointDTO pointDTO = context.getSource();

                return GeometryUtil.createPoint(pointDTO);
            });

        //Converts the Point  to PointDTO
        mapper.typeMap(Point.class, PointDTO.class)
                .setConverter(context -> {
                    Point point = context.getSource();

                    double coordinates[] = {
                          point.getX(), //longitude
                          point.getY(), //latitude
                    };

                    return new PointDTO(coordinates);
                });

        return mapper;
    }
}
