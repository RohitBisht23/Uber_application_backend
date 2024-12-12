package com.RohitBisht.Project.UberProject.UberApp.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDTO {

    private double []coordinates;

    private String type = "Point";


    public PointDTO(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
