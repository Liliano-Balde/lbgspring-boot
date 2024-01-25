package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Car;
import com.lbg.demo.services.CarService;

@RestController
public class CarController {

//	i could input @Autowired in here but in this case im user the private hero service call and add .service on all of them 

	private CarService service;

	public CarController(CarService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Car> createCar(@RequestBody Car newCar) {
		return this.service.createCar(newCar);

	}

	@GetMapping("/get")
	public List<Car> getCars() {
		return this.service.getCars();

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Car> getCar(@PathVariable int id) {

		return this.service.getCar(id);

	}

//	@DeleteMapping("/deleteAll")
//	public String deleteCars(@RequestBody Car removeCar) {
//		return this.service.deleteCars(removeCar);
//
//	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCar(@PathVariable int id) {
		return this.service.deleteCar(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car newCar) {
		return this.service.updateCar(id, newCar);

	}

}
