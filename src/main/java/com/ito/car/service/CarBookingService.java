package com.ito.car.service;

import java.util.List;
import java.util.Optional;

import com.ito.car.dto.CarBooking;

public interface CarBookingService {

	public int bookingCar(CarBooking bookingDetails);
	public Optional<CarBooking> viewBookingById(int bookingId);
	public List<CarBooking> viewBookingByName(String name);
	public List<CarBooking> viewBookingByContactNumber(long contactNumber);
	public List<CarBooking> viewBookingByEmail(String email);
	public boolean cancelBooking(int bookingId);
}
