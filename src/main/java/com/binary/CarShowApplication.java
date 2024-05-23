package com.binary;

import com.binary.Entity.Car;
import com.binary.Entity.Owner;
import com.binary.repository.CarRepository;
import com.binary.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	public static void main(String[] args) {

		SpringApplication.run(CarShowApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {


		Owner owner1 = new Owner("Nathy", "Ford");
		Owner owner2 = new Owner("Nathy", "Ford");
		Owner owner3 = new Owner("Nathy", "Ford");
		Car car1 = new Car(60000, 2024, "XYZ", "Red", "Mustang", "Ford",owner1);

		ownerRepository.save(owner1);
		ownerRepository.save(owner2);
		ownerRepository.save(owner3);
		//car1.setOwner(owner1);
		carRepository.save(car1);
		System.out.println("Car 1 is saved");
		//carRepository.save(car2);


	}
}
