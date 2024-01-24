package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Car;

@RestController
public class CarController {

	private List<Car> cars = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		this.cars.add(car);
		Car newCar = this.cars.get(this.cars.size() - 1);
		return new ResponseEntity<Car>(newCar, HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public ResponseEntity<List<Car>> getCars() {
		return ResponseEntity.ok(cars);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Car> getCar(@PathVariable int id) {
		if (id < 0 || id >= this.cars.size()) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Car found = this.cars.get(id);
		return ResponseEntity.ok(found);
	}

	@DeleteMapping("/deleteAll")
	public String deleteCar(@RequestBody Car removeCar) {
		this.cars.clear();
		return cars.toString();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Car> deleteCar(@PathVariable int id) {
		if (id < 0 || id >= this.cars.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Car removed = this.cars.remove(id);
		return ResponseEntity.ok(removed);

	}

	@PutMapping("/update/{id}")
	public Car updateCar(@PathVariable int id, @RequestBody Car newCar) {
		return this.cars.set(id, newCar);

	}

}
