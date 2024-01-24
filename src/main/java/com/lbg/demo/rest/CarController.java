package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

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
	public String createCar(@RequestBody Car newCar) {
		this.cars.add(newCar);
		return cars.toString();
	}

	@GetMapping("/get")
	public List<Car> getCars() {
		return cars;
	}

	@GetMapping("/get/{id}")
	public Car getCar(@PathVariable int id) {
		return this.cars.get(id);
	}

	@DeleteMapping("/deleteAll")
	public String deleteCar(@RequestBody Car removeCar) {
		this.cars.clear();
		return cars.toString();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCar(@PathVariable int id) {
		this.cars.remove(id);
		return cars.toString();
	}

	@PutMapping("/update/{id}")
	public Car updateCar(@PathVariable int id, @RequestBody Car newCar) {
		return this.cars.set(id, newCar);

	}

}
