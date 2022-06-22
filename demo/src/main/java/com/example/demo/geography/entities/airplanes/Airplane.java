package com.example.demo.geography.entities.airplanes;

import lombok.Data;

@Data
public class Airplane {

	private int id;
	private String name;
	private double longitude;
	// private double latitude;
	// private double altitude;
	// private double rotation;
    private Coordinates coordinates;

	public Airplane(int id, String name, double lon, double lat, double alt){
		this.id = id;
		this.name = name;
		// this.longitude = lon;
		// this.latitude = lat;
		// this.altitude = alt;
		
        this.coordinates = new Coordinates(lon, lat, alt, 0);
	}

	public void setCoordinates(double longitude, double latitude, double altitude){
		// this.longitude = lon;
		// this.latitude = lat;
		// this.altitude = alt;
        this.coordinates.setAltitude(altitude);
        this.coordinates.setLatitude(latitude);
        this.coordinates.setLongitude(longitude);
	}
	
	 

}
