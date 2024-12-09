package com.RohitBisht.Project.UberProject.UberApp.Configs;

import com.RohitBisht.Project.UberProject.UberApp.DTO.PointDTO;
import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration  // Add this annotation
public class ModelConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.typeMap(PointDTO.class, Point)
                .setConverter(converter -> {
                    PointDTO pointDTO = converter.getSource();
                });

        return mapper;
    }
}
