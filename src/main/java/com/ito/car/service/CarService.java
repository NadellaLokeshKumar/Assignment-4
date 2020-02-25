package com.ito.car.service;

import java.util.List;

import com.ito.car.dto.Car;

public interface CarService {

	public boolean addCar(Car car);
	public boolean remove(int id);
	public List<Car> search(String searchElement);
	public List<Car> searchByCost(double cost);
	public List<Car> allCars();
}
