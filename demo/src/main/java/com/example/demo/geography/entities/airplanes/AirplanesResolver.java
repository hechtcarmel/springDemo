package com.example.demo.geography.entities.airplanes;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class AirplanesResolver {

@QueryMapping
  public Airplane airplane(){
	int id = 0;
    System.out.println("QueryMapping: airplane getting id: " + id);
    return ActiveAirplanesManager.getAirplane(id);
}

  //@SchemaMapping(typeName = "Query", value = "airplanes")
  @QueryMapping
  public List<Airplane> airplanes(){
    System.out.println("QueryMapping: airplanes");
    List<Airplane> airplanes =  ActiveAirplanesManager.getAirplanes();
    System.out.println("Airplanes Res: " + airplanes.toString());
    return airplanes;
  }

  @QueryMapping
  public Airplane findAirplane(@Argument Integer id){
    System.out.println("QueryMapping: airplane getting id: " + id.toString());
    return ActiveAirplanesManager.getAirplane(id);
  }
	
}