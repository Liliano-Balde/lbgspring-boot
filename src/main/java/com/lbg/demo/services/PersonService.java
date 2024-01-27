package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Person;
import com.lbg.demo.repo.PersonRepo;

@Service
public class PersonService {

	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;

	}

	public ResponseEntity<Person> createPerson(Person newPerson) {
		Person created = this.repo.save(newPerson);
		return new ResponseEntity<Person>(created, HttpStatus.CREATED);

	}

	public List<Person> getPerson() {
		return repo.findAll();
	}

	public ResponseEntity<Person> getPerson(int id) {
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);

		}

		Person body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deletePerson(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<Person> updatePerson(int id, Person newPerson) {

		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Person existing = found.get();

		if (newPerson.getName() != null) {
			existing.setName(newPerson.getName());
		}
		if (newPerson.getLocation() != null) {
			existing.setLocation(newPerson.getLocation());

		}
		Person updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

	public Optional<Person> findById(Integer id) {
		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
