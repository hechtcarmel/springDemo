package com.example.demo.geography.entities.airplanes;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.Constants;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

//@Log4j
public class ActiveAirplanesManager {
	
	//private static Logger logger = LogManager.getLogger(AirplanesManager.class);
	private static List<Airplane> activeAirplanes;
	
	static {
		activeAirplanes = new ArrayList<>();
		int AIRPLANES_NUM = 1000;
		for (int i = 0; i < AIRPLANES_NUM; i++) {

			int id = i;
			String name = "Airplane " + id;
			double lon = Constants.LON_MIN + (Constants.LON_MAX - Constants.LON_MIN) * Math.random();
			double lat = Constants.LAT_MIN + (Constants.LAT_MAX - Constants.LAT_MIN) * Math.random();
			double alt = 150;

			Airplane airplaneFeat = new Airplane(id, name, lon, lat, alt);
			activeAirplanes.add(airplaneFeat);
		}
		System.out.println("Demo Airplanes: " + activeAirplanes.toString());
	}
	
//	private static List<Airplane> initTestAirplanes() {
//		int AIRPLANES_NUM = 10000;
//		List<Airplane> demoAirplanes = new ArrayList<>();
//		for (int i = 0; i < AIRPLANES_NUM; i++) {
//
//			int id = i;
//			String name = "Airplane " + id;
//			double lon = Constants.LON_MIN + (Constants.LON_MAX - Constants.LON_MIN) * Math.random();
//			double lat = Constants.LAT_MIN + (Constants.LAT_MAX - Constants.LAT_MIN) * Math.random();
//			double alt = 150;
//
//			Airplane airplaneFeat = new Airplane(id, name, lon, lat, alt);
//			demoAirplanes.add(airplaneFeat);
//		}
//		System.out.println("Demo Airplanes: " + demoAirplanes.toString());
//		return demoAirplanes;
//	}

	private static void updateAirplanesCoordinates() {
		double stepSize = 15;

		for (Airplane airplane : activeAirplanes) {
			double latitudeStep = stepSize * (Math.random() - 0.5);
			double longitudeStep = stepSize * (Math.random() - 0.5);

			double lon = airplane.getLongitude() + longitudeStep;
			double lat = (double)airplane.getCoordinates().getLatitude() + latitudeStep;
			double alt = 100;

			airplane.getCoordinates().setLatitude(lat);
			airplane.getCoordinates().setLongitude(lon);
			airplane.getCoordinates().setAltitude(alt);

			double rotation = Math.atan(latitudeStep/longitudeStep) - Math.PI/2 + (longitudeStep < 0 ? Math.PI : 0);
			airplane.getCoordinates().setRotation(rotation);
			//System.out.println(airplane);
		}
	}
	
//	public ActiveAirplanesManager(){
//		initTestAirplanes();
//	}

	public static List<Airplane> getAirplanes() {
		//logger.info("Entered");
		
		updateAirplanesCoordinates();
		System.out.println("Returning airplanes" + activeAirplanes.toString());
		return activeAirplanes;
		
	}
	
	public static Airplane getAirplane(int id) {

		Airplane airplane = activeAirplanes.stream().filter(a -> a.getId() == id).findFirst().orElse(null);

		System.out.println("Getting airplane" + airplane.toString());
		return airplane;
	}
	
}
