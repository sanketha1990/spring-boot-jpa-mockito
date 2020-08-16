package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.Person;

@Repository("personDetailsRepository")
public interface PersonDetailsRepository extends JpaRepository<Person, Long>{

}
