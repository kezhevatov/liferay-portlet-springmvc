package com.simbirsoft.andrey.liferay.dao;

import java.util.List;

import com.simbirsoft.andrey.liferay.model.Person;

public interface PersonDao {
	
	Person getPersonById(Long id);
	
	List<Person> getAllPerson();	
	
	void removePerson(Long id);
	
	void saveOrUpdatePerson(Person person);	
}
