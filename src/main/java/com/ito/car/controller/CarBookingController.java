package com.ito.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ito.car.dto.CarBooking;
import com.ito.car.dto.CarResponse;
import com.ito.car.service.CarBookingService;

@RestController
public class CarBookingController {

	@Autowired
	public CarBookingService bookingService;
	
	@PostMapping(path = "/addBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addCar(@RequestBody CarBooking bookingDetails) {
		int id = bookingService.bookingCar(bookingDetails);	
		return "Booking id is "+id;
	}
	
	@GetMapping(path = "/searchId/{searchId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<CarBooking> searchById(@PathVariable("searchId") int searchId) {
		Optional<CarBooking> bookedDetails = bookingService.viewBookingById(searchId);
		return bookedDetails;
	}
	
	@GetMapping(path = "/searchEmail/{searchEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarBooking> searchByEmail(@PathVariable("searchEmail") String searchEmail) {
		List<CarBooking> bookedDetails = bookingService.viewBookingByEmail(searchEmail);
		return bookedDetails;
	}
	
	@GetMapping(path = "/searchName/{searchName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarBooking> searchByName(@PathVariable("searchName") String searchName) {
		List<CarBooking> bookedDetails = bookingService.viewBookingByName(searchName);
		return bookedDetails;
	}
	
	@GetMapping(path = "/searchNumber/{searchNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarBooking> searchByNumber(@PathVariable("searchNumber") long searchNumber) {
		List<CarBooking> bookedDetails = bookingService.viewBookingByContactNumber(searchNumber);
		return bookedDetails;
	}
	
	@DeleteMapping(path = "/cancelBooking/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CarResponse cancelBooking(@PathVariable("id") int id) {
		CarResponse response = new CarResponse();
		if (bookingService.cancelBooking(id)) {
			response.setStatusCode(201);
			response.setStatusMessage("successfully deleted");
		} else {
			response.setStatusCode(400);
			response.setStatusMessage("Failed to delete");
		}
		return response;
	}
}
