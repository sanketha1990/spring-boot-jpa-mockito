package com.springboot.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.exception.PersonException;
import com.springboot.app.model.Person;
import com.springboot.app.model.Response;
import com.springboot.app.service.PersonDetailService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	public PersonDetailService personDetailService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPersonObject() {

		System.out.println("/getAll API call");
		return new ResponseEntity<List<Person>>(personDetailService.getAllPerson(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Person> savePerson(@RequestBody Person person) throws Exception {
		System.out.println("/add API call");
		return new ResponseEntity<Person>(personDetailService.save(person), HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{personId}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonbyId(@PathVariable("personId") long personId) throws PersonException {
		System.out.println("/get/{personId} API call");
		ResponseEntity<Person> response = new ResponseEntity<Person>(personDetailService.getByPersonId(personId),
				HttpStatus.OK);
		if (response == null || response.getBody() == null) {
			throw new PersonException("Person not present");
		}
		return response;
	}

	@RequestMapping(value = "/delete/{personId}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deletePersonbyId(@PathVariable("personId") long personId) throws PersonException {
		System.out.println("/delete/{personId} DELETE API call");

		Person person = personDetailService.getByPersonId(personId);

		if (person == null || person.getPersonId() <= 0) {
			throw new PersonException("Person ID does not exist");
		}
		personDetailService.deletePerson(person);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Record has been deleted"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) throws Exception {
		System.out.println("/update API call");

		Person id = personDetailService.getByPersonId(person.getPersonId());
		if (id == null || id.getPersonId() <= 0) {
			throw new PersonException("Person Id does not exist can't update");
		}

		return new ResponseEntity<Person>(personDetailService.save(person), HttpStatus.OK);
	}

}
