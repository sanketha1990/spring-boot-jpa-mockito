package com.springboot.app.service;

import java.util.List;

import com.springboot.app.model.Person;

public interface PersonDetailService {
	public List<Person> getAllPerson();

	public Person getByPersonId(long id);

	public Person save(Person person);

	public void deletePerson(Person person);
}
