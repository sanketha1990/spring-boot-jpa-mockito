package com.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Person_Table")
public class Person {

	@Id
	@GeneratedValue
	private long personId;
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}
}
