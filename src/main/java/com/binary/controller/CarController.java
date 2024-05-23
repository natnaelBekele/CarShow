package com.binary.controller;

import com.binary.Entity.Car;
import com.binary.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
   // localhost:8080/api/v1/car/newlist
    @GetMapping("/list")
    public List<Car> getAllCars() {
        return (List<Car>) carService.getAllCars();
    }

    @GetMapping("/newlist")
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/list1")
    public ResponseEntity<List<Car>> getAllCarsByName() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        //System.out.println(car);
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody Car updatedcar) {
        return new ResponseEntity<>(carService.updateCar(id, updatedcar), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteCar(@PathVariable long id) {
        return new ResponseEntity<>(carService.deleteCar(id), HttpStatus.OK);
    }

}