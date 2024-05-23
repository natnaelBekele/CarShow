package com.binary.services;

import com.binary.Entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> getAllCars();
    public Car createCar(Car car);
    public Car updateCar(long id, Car car);
    public Long deleteCar(Long id);
    public Car getCarById(long id);
}
