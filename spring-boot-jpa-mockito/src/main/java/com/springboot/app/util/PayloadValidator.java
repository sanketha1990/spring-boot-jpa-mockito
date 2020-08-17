package com.springboot.app.util;

import com.springboot.app.model.Person;

public class PayloadValidator {

	public static boolean validateCreatePayload(Person person) {
		if (person.getPersonId() > 0) {
			return false;
		}
		return true;
	}
}
