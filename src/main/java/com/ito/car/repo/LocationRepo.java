package com.ito.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ito.car.dto.Location;

public interface LocationRepo extends JpaRepository<Location, Integer>{

	// If we have same type of cars in different locations, it will remove particular car form particular location.
	@Transactional    
	@Modifying
	@Query(value = "update car set car.location_id = null where car.location_id=:locationId AND car.type=:type", nativeQuery = true)
	public void deleteCarFromLocation(int locationId, String type);
	
	@Transactional
	@Modifying
	@Query(value = "update car set car.location_id =:locationId where car.type=:type", nativeQuery = true)
	public void addCarToLocation(int locationId, String type);

}
