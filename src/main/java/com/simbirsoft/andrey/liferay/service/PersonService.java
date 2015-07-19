package com.simbirsoft.andrey.liferay.service;

import java.util.List;

import com.simbirsoft.andrey.liferay.model.Person;

public interface PersonService {

	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();	
	
	void removePerson(Integer id);
	
	void saveOrUpdatePerson(Person person);
}
