package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Constants;

import net.minidev.json.JSONObject;
@RestController
public class AirplanesManager {
	
	private static Logger logger = LogManager.getLogger(AirplanesManager.class);
	private List<AirplaneFeature> airplanesFeatures = new ArrayList<>();
	
	private void initTestAirplanes() {
		int AIRPLANES_NUM = 20;
		for (int i = 0; i < AIRPLANES_NUM; i++) {

			int id = i;
			String name = "Airplane " + id;
			double lon = Constants.LON_MIN + (Constants.LON_MAX - Constants.LON_MIN) * Math.random();
			double lat = Constants.LAT_MIN + (Constants.LAT_MAX - Constants.LAT_MIN) * Math.random();
			double alt = 150;

			AirplaneFeature airplaneFeat = new AirplaneFeature(id, name, lon, lat, alt);
			airplanesFeatures.add(airplaneFeat);
		}
	}

	public void updateAirplanesCoordinates() {
		double stepSize = 15;

		for (AirplaneFeature airplane : airplanesFeatures) {
			double latitudeStep = stepSize * (Math.random() - 0.5);
			double longitudeStep = stepSize * (Math.random() - 0.5);

			double lon = airplane.getLongitude() + longitudeStep;
			double lat = (double)airplane.getLatitude() + latitudeStep;
			double alt = 100;

			airplane.setLatitude(lat);
			airplane.setLongitude(lon);
			airplane.setAltitude(alt);

			double rotation = Math.atan(latitudeStep/longitudeStep) - Math.PI/2 + (longitudeStep < 0 ? Math.PI : 0);
			airplane.setRotation(rotation);
			System.out.println(airplane);
		}
	}
	
	public AirplanesManager(){
		initTestAirplanes();
	}

	@GetMapping(path = "/airplanes/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> welcome() {
		logger.info("Entered");
		
		updateAirplanesCoordinates();
		//System.out.println("Returning airplanes" + airplanes.toString());
		return new ResponseEntity<>(airplanesFeatures, HttpStatus.OK);

		
	}
	
	
}
