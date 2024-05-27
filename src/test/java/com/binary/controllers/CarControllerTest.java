package com.binary.controllers;

import com.binary.controller.CarController;
import com.binary.Entity.Car;
import com.binary.service.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {
    @InjectMocks
    private CarController carController;
    @Mock
    private CarServiceImpl carServiceImpl;

    @Test
    @DisplayName("car controller get all success")
    public void carController_getAllCars_success() {

        List<Car> expectedCars = new ArrayList<Car>();
        Car car = new Car();
        car.setId(1L);
        car.setPrice(2500);
        car.setModel("BMW");
        expectedCars.add(car);

        Mockito.when(carServiceImpl.getAllCars()).thenReturn(expectedCars);

        ResponseEntity<List<Car>> result = carController.getCars();

        Assertions.assertEquals(1, result.getBody().size());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

    }
    @Test
    @DisplayName("car controller get by ID success case")
    public void carController_createCar_success() {
        Car carBeforeCreated = new Car();
        carBeforeCreated.setId(2L);

        Car carCreated = new Car();
        carCreated.setId(3L);
        carBeforeCreated.setModel(carBeforeCreated.getModel());

        Mockito.when(carServiceImpl.createCar(carBeforeCreated)).thenReturn(carCreated);

        ResponseEntity<Car> result = carController.createCar(carBeforeCreated);

        Assertions.assertEquals(carBeforeCreated.getModel(), result.getBody().getModel());
        Assertions.assertNotNull(result.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED,result.getStatusCode());

    }
    @Test
    @DisplayName("car controller update car success test case")
    public void carController_updateCar_success() {
        Car updates = new Car();
        updates.setYear(2020);
        updates.setColor("Red");

        long carIdThatNeedsToBeUpdated = 45l;

        Car updatedCar = new Car();
        updatedCar.setId(carIdThatNeedsToBeUpdated);
        updatedCar.setYear(updates.getYear());
        updatedCar.setColor(updates.getColor());

        Mockito.when(carServiceImpl.updateCar(carIdThatNeedsToBeUpdated,updates)).thenReturn(updatedCar);

        ResponseEntity<Car> result = carController.updateCar(carIdThatNeedsToBeUpdated, updates);

        Assertions.assertEquals(updatedCar.getYear(), result.getBody().getYear());
        Assertions.assertEquals(updatedCar.getColor(), result.getBody().getColor());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(carIdThatNeedsToBeUpdated, result.getBody().getId());



    }

    @Test
    @DisplayName("car controller delete car success test case")
    public void carController_deleteCar_success() {
        long carIdThatNeedsToBeDeleted = 45L;

Mockito.when(carServiceImpl.deleteCar(carIdThatNeedsToBeDeleted)).thenReturn(carIdThatNeedsToBeDeleted);
        ResponseEntity<Long> result = carController.deleteCar(carIdThatNeedsToBeDeleted);
        Assertions.assertEquals(carIdThatNeedsToBeDeleted, result.getBody());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

    }

}