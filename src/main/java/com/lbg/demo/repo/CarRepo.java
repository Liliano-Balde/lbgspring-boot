package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
