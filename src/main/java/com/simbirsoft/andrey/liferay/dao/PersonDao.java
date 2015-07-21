package com.simbirsoft.andrey.liferay.dao;

import java.util.List;

import com.simbirsoft.andrey.liferay.model.Person;

public interface PersonDao {
	
	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();	
	
	void removePerson(Person person);
	
	Integer saveOrUpdatePerson(Person person);	
}
