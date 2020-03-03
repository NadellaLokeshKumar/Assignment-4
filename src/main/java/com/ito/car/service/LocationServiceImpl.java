package com.ito.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ito.car.dto.Location;
import com.ito.car.repo.LocationRepo;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	public LocationRepo locationRepo;
	
	@Override
	public boolean addLocation(Location location) {
		locationRepo.save(location);
		return true;
	}

	@Override
	public boolean deleteCarFromLocation(int locationId, String type) {
		locationRepo.deleteCarFromLocation(locationId, type);
		return true;
	}
	
	@Override
	public boolean addCarToLocation(int locationId, String type) {
		locationRepo.addCarToLocation(locationId, type);
		return true;
	}

}
