package com.simbirsoft.andrey.liferay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simbirsoft.andrey.liferay.dao.PersonDao;
import com.simbirsoft.andrey.liferay.model.Person;
import com.simbirsoft.andrey.liferay.service.PersonService;

@Transactional
@Service("PersonService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Transactional
	public Integer saveOrUpdatePerson(Person person) {
		return personDao.saveOrUpdatePerson(person);
	}

	@Transactional
	public Person getPersonById(Integer id) {
		return personDao.getPersonById(id);
	}

	@Transactional
	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}

	@Transactional
	public void removePerson(Person person) {
		personDao.removePerson(person);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
