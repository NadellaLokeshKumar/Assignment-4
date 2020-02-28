package com.ito.car.repo;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ito.car.dto.Car;
import com.ito.car.dto.CarBooking;

public interface CarBookingRepo extends JpaRepository<CarBooking, Integer> {

	public List<CarBooking> findBypersonName(String personName);

	public List<CarBooking> findByContactNumber(long contactNumber);

	public List<CarBooking> findByEmail(String email);

	@Query(value = "select distinct car.* from car, car_booking where car.booking_id is null OR (car_booking.booking_id=car.booking_id AND ((:startDate NOT BETWEEN car_booking.start_date AND car_booking.end_date) AND (:endDate NOT BETWEEN car_booking.start_date AND car_booking.end_date)))", nativeQuery = true)
	public List<Object> viewCarsBetweenDate(Date startDate, Date endDate);
}
