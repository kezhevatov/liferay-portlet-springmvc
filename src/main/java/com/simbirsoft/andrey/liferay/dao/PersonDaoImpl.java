package com.simbirsoft.andrey.liferay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simbirsoft.andrey.liferay.controller.PersonController;
import com.simbirsoft.andrey.liferay.model.Person;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public PersonDaoImpl(){
		logger.info("PersonDao created");
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void saveOrUpdatePerson(Person person) {
		sessionFactory.openSession().saveOrUpdate(person);
	}
	
	@Transactional
	public Person getPersonById(Long id) {
		Person person = (Person)sessionFactory.openSession().get(Person.class, id);
		return person;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Person> getAllPerson() {
		return sessionFactory.openSession().createQuery("from Person").list();
	}
	
	@Transactional
	public void removePerson(Long id) {		
		Person person = getPersonById(id);
		if (person != null)
			sessionFactory.openSession().delete(person);
	}

}
