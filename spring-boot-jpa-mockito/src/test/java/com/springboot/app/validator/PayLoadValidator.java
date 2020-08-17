package com.springboot.app.validator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.springboot.app.model.Person;
import com.springboot.app.util.PayloadValidator;

class PayLoadValidator {
	
	@Test
	public void validatePayload1() {
		Person person=new Person(0,"sanketh",29);
		assertEquals(true, PayloadValidator.validateCreatePayload(person));
	}
	
	@Test
	public void validatePayload2() {
		Person person=new Person(1,"sanketh",29);
		assertEquals(false, PayloadValidator.validateCreatePayload(person));
	}

}
