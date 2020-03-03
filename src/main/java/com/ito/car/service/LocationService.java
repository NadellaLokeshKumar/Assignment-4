package com.ito.car.service;

import com.ito.car.dto.Location;

public interface LocationService {

	public boolean addLocation(Location location);
	public boolean deleteCarFromLocation(int locationId, String type);
	public boolean addCarToLocation(int locationId, String type);
}
