package com.simbirsoft.andrey.liferay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simbirsoft.andrey.liferay.dao.PersonDao;
import com.simbirsoft.andrey.liferay.model.Person;

@Transactional
@Service("PersonService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	public PersonServiceImpl(){		
	}
	
	@Transactional
	public void saveOrUpdatePerson(Person person) {
		personDao.saveOrUpdatePerson(person);
	}

	@Transactional
	public Person getPersonById(Long id) {
		return personDao.getPersonById(id);
	}

	@Transactional
	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}

	@Transactional
	public void removePerson(Long id) {
		personDao.removePerson(id);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}