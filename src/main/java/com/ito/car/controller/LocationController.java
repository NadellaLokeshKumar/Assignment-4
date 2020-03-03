package com.ito.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ito.car.dto.CarResponse;
import com.ito.car.dto.Location;
import com.ito.car.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	public LocationService service;
	
	@PostMapping(path = "/addLocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CarResponse addLocation(@RequestBody Location location) {
		CarResponse response = new CarResponse();
		if(service.addLocation(location)) {
			response.setStatusCode(201);
			response.setStatusMessage("Success");
		} else {
			response.setStatusCode(401);
			response.setStatusMessage("Failed");
		}
		return response;
	}
	
	@PutMapping(path = "/deleteCarFromLocation/{locationId}/{carType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CarResponse deleteCarFromLocation(@PathVariable("locationId") int locationId, @PathVariable("carType") String carType) {
		CarResponse response = new CarResponse();
		if(service.deleteCarFromLocation(locationId, carType)) {
			response.setStatusCode(201);
			response.setStatusMessage("Success");
		} else {
			response.setStatusCode(401);
			response.setStatusMessage("Failed");
		}
		return response;
	}
	
	@PutMapping(path = "/addCarToLocation/{locationId}/{carType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CarResponse addCarToLocation(@PathVariable("locationId") int locationId, @PathVariable("carType") String carType) {
		CarResponse response = new CarResponse();
		if(service.addCarToLocation(locationId, carType)) {
			response.setStatusCode(201);
			response.setStatusMessage("Success");
		} else {
			response.setStatusCode(401);
			response.setStatusMessage("Failed");
		}
		return response;
	}
}
