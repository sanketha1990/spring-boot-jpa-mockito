package com.springboot.app.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.springboot.app.service.PersonDetailService;
import com.springboot.app.service.PersonDetailServiceImpl;

@SpringBootTest
class PersonServiceTest {

	@Mock
	PersonDetailsRepository personRepo;

	@InjectMocks
	PersonDetailService personService=new PersonDetailServiceImpl();
	
	@Before
	public void setup(){
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
		List<Person> result = personService.getAllPerson();
		assertEquals(4, result.size());
	}

}
