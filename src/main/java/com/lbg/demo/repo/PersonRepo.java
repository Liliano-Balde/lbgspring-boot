package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
