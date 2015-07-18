package com.simbirsoft.andrey.liferay.service;

import java.util.List;

import com.simbirsoft.andrey.liferay.model.Person;

public interface PersonService {

	Person getPersonById(Long id);
	
	List<Person> getAllPerson();	
	
	void removePerson(Long id);
	
	void saveOrUpdatePerson(Person person);
}
