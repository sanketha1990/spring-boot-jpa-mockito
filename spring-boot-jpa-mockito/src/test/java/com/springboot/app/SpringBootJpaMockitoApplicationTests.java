package com.springboot.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.app.model.Person;
import com.springboot.app.repository.PersonDetailsRepository;
import com.springboot.app.service.PersonDetailServiceImpl;

@SpringBootTest
class SpringBootJpaMockitoApplicationTests {

	@InjectMocks
	PersonDetailServiceImpl personDetailServiceImpl;

	@Mock
	PersonDetailsRepository personRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllData() {

		List<Person> list = new ArrayList<Person>();
		list.add(new Person("samip", 30));
		list.add(new Person("samiksha", 15));
		list.add(new Person("samrat", 35));
		list.add(new Person("virat", 40));

		when(personRepo.findAll()).thenReturn(list);
		List<Person> result = personDetailServiceImpl.getAllPerson();
		assertEquals(4, result.size());
	}

	@Test
	public void getByPersonId() {
		Person p = new Person("Sanketh", 30);
		when(personRepo.findByPersonId(1)).thenReturn(p);
		Person result = personDetailServiceImpl.getByPersonId(1);
		assertEquals("Sanketh", result.getName());
		assertEquals(30, result.getAge());
	}

	@Test
	public void savePerson() {
		Person person = new Person("Samrat", 40);
		when(personRepo.save(person)).thenReturn(person);
		Person result = personDetailServiceImpl.save(person);
		assertEquals("Samrat", result.getName());
		assertEquals(40, result.getAge());
	}

	@Test
	public void deletePerson() {
		Person person = new Person("Samrat", 40);
		personDetailServiceImpl.deletePerson(person);
		verify(personRepo).delete(person);
	}

}
