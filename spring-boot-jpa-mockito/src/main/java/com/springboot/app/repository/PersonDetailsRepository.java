package com.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.Person;

@Repository("personDetailsRepository")
public interface PersonDetailsRepository extends CrudRepository<Person, Long>{
public Person findByPersonId(long personId);
}
