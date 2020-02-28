package com.ito.car.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ito.car.dto.Car;
import com.ito.car.dto.CarBooking;
import com.ito.car.repo.CarBookingRepo;

@Service
public class CarBookingServiceImpl implements CarBookingService {
	
	@Autowired
	public CarBookingRepo bookingRepo;

	@Override
	public int bookingCar(CarBooking bookingDetails) {
		if(bookingRepo.save(bookingDetails) != null) {
			return bookingDetails.getBookingId();
		}
		return 0;
	}

	@Override
	public Optional<CarBooking> viewBookingById(int bookingId) {
		Optional<CarBooking> bookingDetails = bookingRepo.findById(bookingId);
		return bookingDetails;
	}

	@Override
	public List<CarBooking> viewBookingByName(String name) {
		List<CarBooking> bookingDetails = bookingRepo.findBypersonName(name);
		return bookingDetails;
	}

	@Override
	public List<CarBooking> viewBookingByContactNumber(long contactNumber) {
		List<CarBooking> bookingDetails = bookingRepo.findByContactNumber(contactNumber);
		return bookingDetails;
	}

	@Override
	public List<CarBooking> viewBookingByEmail(String email) {
		List<CarBooking> bookingDetails = bookingRepo.findByEmail(email);
		return bookingDetails;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		bookingRepo.deleteById(bookingId);
		return true;
	}

	@Override
	public List<Object> viewCarsBetweenDate(Date startDate, Date endDate) {
		return bookingRepo.viewCarsBetweenDate(startDate, endDate);
	}
}
