package com.springboot.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Person;
import com.springboot.app.repository.PersonDetailsRepository;

@Service("personService")
public class PersonDetailServiceImpl implements PersonDetailService {

	@Autowired
	private PersonDetailsRepository personDetailsRepository;
	
	List<Person> persons =null;

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		persons = new ArrayList<Person>();
		personDetailsRepository.findAll().forEach(persons::add);
		return persons;
	}

	@Override
	public Person getByPersonId(long id) {
		// TODO Auto-generated method stub
		return personDetailsRepository.findByPersonId(id);
	}

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personDetailsRepository.save(person);
	}

	@Override
	public void deletePerson(Person personId) {
		personDetailsRepository.delete(personId);
	}

}
