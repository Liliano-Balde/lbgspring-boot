package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Car;
import com.lbg.demo.repo.CarRepo;

@Service
public class CarService {

	private CarRepo repo;

	public CarService(CarRepo repo) {
		super();
		this.repo = repo;

	}

	public ResponseEntity<Car> createCar(Car newCar) {
		Car created = this.repo.save(newCar);
		return new ResponseEntity<Car>(created, HttpStatus.CREATED);
	}

	public List<Car> getCars() {
		return this.repo.findAll();

	}

	public ResponseEntity<Car> getCar(int id) {
		Optional<Car> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);

		}

		Car body = found.get();
		return ResponseEntity.ok(body);
	}

//	public String deleteCars(Car removeCar) {
//		this.cars.clear();
//		return cars.toString();
//	}

	public boolean deleteCar(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<Car> updateCar(int id, Car newCar) {

		Optional<Car> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Car existing = found.get();

		if (newCar.getMake() != null) {
			existing.setMake(newCar.getMake());
		}
		if (newCar.getModel() != null) {
			existing.setModel(newCar.getModel());

		}
		Car updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

//	queries, to check monday if its functional
//	public List<Car> findCarsByMake(String make) {
//		// Find cars by make using a derived query
//		return repo.findByMakeIgnoreCase(make);
//	}

}
