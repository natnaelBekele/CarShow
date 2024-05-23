package com.binary.controller;

import com.binary.Entity.Car;
import com.binary.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String carMessage() {
        return "Hello, This is from Rest Controller";
    }

    @GetMapping("/list")
    public List<Car> getAllCars() {
        return (List<Car>) carService.getAllCars();
    }
    @GetMapping("/newlist")
public ResponseEntity<List<Car>>getCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

}