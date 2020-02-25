package com.ito.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ito.car.dto.Car;
import com.ito.car.repo.CarRepo;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	public CarRepo repo;

	@Override
	public boolean addCar(Car car) {
		if(car != null) {
			repo.save(car);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(int id) {
		if(id > 0) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Car> search(String searchElement) {
		List<Car> cars = repo.search(searchElement);
		return cars;
	}

	@Override
	public List<Car> allCars() {
		List<Car> cars = repo.findAll();
		return cars;
	}

	@Override
	public List<Car> searchByCost(double cost) {
		List<Car> cars = repo.searchByCost(cost);
		return cars;
	}

}
