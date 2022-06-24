package com.example.demo.geography.entities.airplanes;

import com.example.demo.Constants.EAirplaneType;

import lombok.Data;

@Data
public class Airplane {

	private int id;
	private String name;
	private double longitude;
	private String description;
    private Coordinates coordinates;
    private EAirplaneType type;

	public Airplane(int id, String name, double lon, double lat, double alt, EAirplaneType type){
		this.id = id;
		this.name = name;
		this.description = "I am airplane number " + id;
		this.type = type;
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
