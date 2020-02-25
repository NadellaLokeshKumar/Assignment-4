package com.ito.car.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ito.car.dto.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{
	
	@Query("from Car where type=:searchElement OR modelName=:searchElement")
	public List<Car> search(String searchElement);
	
	@Query("from Car where costPerDay<=:costPerDay")
	public List<Car> searchByCost(double costPerDay);
	
}
