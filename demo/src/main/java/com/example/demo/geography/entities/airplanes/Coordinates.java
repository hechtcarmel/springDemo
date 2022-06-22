package com.example.demo.geography.entities.airplanes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {
	private double longitude;
	private double latitude;
	private double altitude;
	private double rotation = 0;
}
