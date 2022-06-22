package com.example.demo;


public class AirplaneFeature {

	private int id;
	private String name;
	private double longitude;
	private double latitude;
	private double altitude;
	private double rotation;

	public AirplaneFeature(int id, String name, double lon, double lat, double alt){
		this.id = id;
		this.name = name;
		this.longitude = lon;
		this.latitude = lat;
		this.altitude = alt;
		this.rotation=0;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public void setCoordinates(double lon, double lat, double alt){
		this.longitude = lon;
		this.latitude = lat;
		this.altitude = alt;
	}

	public String toString(){
		return "Name: " + name + " Longitude: " + longitude + " Latitude: " + latitude + " Altitude: " + altitude;
	}

	public int getId() {
		return id;
	}

	//java hash by id
	public int hashCode() {
		return id;
	}

	//java equals by id
	public boolean equals(Object obj) {
		if (obj instanceof AirplaneFeature) {
			AirplaneFeature other = (AirplaneFeature) obj;
			return this.id == other.id;
		}
		return false;
	}

	//generate jsonObject
	// public JSONObject toJSONObject(){
	// 	JSONObject jsonObject = new JSONObject();
	// 	jsonObject.put("id", id);
	// 	jsonObject.put("name", name);
	// 	jsonObject.put("lon", longitude);
	// 	jsonObject.put("lat", latitude);
	// 	jsonObject.put("alt", altitude);
	// 	jsonObject.put("rotation", rotation);

	// 	return jsonObject;
	// }



	
	
	
}
