package com.example.demo.geography.entities.airplanes;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AirplanesResolver {

@QueryMapping
  public Airplane airplane(){
	int id = 0;
    System.out.println("QueryMapping: airplane getting id: " + id);
    return ActiveAirplanesManager.getAirplane(id);
}

  @SchemaMapping(typeName = "Query", value = "airplanes")
  public List<Airplane> airplanes(){
    System.out.println("QueryMapping: airplanes");
    List<Airplane> airplanes =  ActiveAirplanesManager.getAirplanes();
    System.out.println("Airplanes Res: " + airplanes.toString());
    return airplanes;
}
	
}