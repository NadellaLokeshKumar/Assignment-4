package com.ito.car.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ito.car.dto.CarBooking;

public interface CarBookingRepo extends JpaRepository<CarBooking, Integer> {


	public List<CarBooking> findBypersonName(String personName);

	public List<CarBooking> findByContactNumber(long contactNumber);

	public List<CarBooking> findByEmail(String email);
}
