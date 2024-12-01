package com.RohitBisht.Project.UberProject.UberApp.DTO;

import lombok.Data;

@Data
public class PointDTO {

    private double []coordinates;

    private String type = "Point";
}
