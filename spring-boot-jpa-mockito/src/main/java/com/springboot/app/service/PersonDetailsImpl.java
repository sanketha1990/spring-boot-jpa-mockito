package com.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Person;
import com.springboot.app.repository.PersonDetailsRepository;

@Service("PersonService")
public class PersonDetailsImpl implements PersonDetailService {

	@Autowired
	private PersonDetailsRepository personDetailsRepository;

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personDetailsRepository.findAll();
	}

	@Override
	public Person getByPersonId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personDetailsRepository.save(person);
	}

	@Override
	public void deletePerson(long personId) {
		personDetailsRepository.deleteById(personId);
	}

}
