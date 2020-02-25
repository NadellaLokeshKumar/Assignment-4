package com.ito.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ito.car.dto.Car;
import com.ito.car.dto.CarResponse;
import com.ito.car.service.CarService;

@RestController
public class CarController {

	@Autowired
	public CarService service;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CarResponse addCar(@RequestBody Car car) {
		CarResponse response = new CarResponse();
		if (service.addCar(car)) {
			response.setStatusCode(201);
			response.setStatusMessage("successfully added");
		} else {
			response.setStatusCode(400);
			response.setStatusMessage("Failed to add");
		}
		return response;
	}
	
	@DeleteMapping(path = "/remove/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CarResponse removeCar(@PathVariable("id") int id) {
		CarResponse response = new CarResponse();
		if (service.remove(id)) {
			response.setStatusCode(201);
			response.setStatusMessage("successfully deleted");
		} else {
			response.setStatusCode(400);
			response.setStatusMessage("Failed to delete");
		}
		return response;
	}
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getAllCars() {
		List<Car> cars = service.allCars();
		if (!cars.isEmpty()) {
			return cars;
		}
		return null;
	}
	
	@GetMapping(path = "/searchElement/{searchElement}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> search(@PathVariable("searchElement") String searchElement) {
		List<Car> cars = service.search(searchElement);
		if (!cars.isEmpty()) {
			return cars;
		}
		return null;
	}
	
	@GetMapping(path = "/searchByCost/{cost}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> searchByCost(@PathVariable("cost") double cost) {
		List<Car> cars = service.searchByCost(cost);
		if (!cars.isEmpty()) {
			return cars;
		}
		return null;
	}
}
