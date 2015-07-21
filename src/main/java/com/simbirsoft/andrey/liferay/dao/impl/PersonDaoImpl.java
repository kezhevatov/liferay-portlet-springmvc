package com.simbirsoft.andrey.liferay.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simbirsoft.andrey.liferay.dao.PersonDao;
import com.simbirsoft.andrey.liferay.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer saveOrUpdatePerson(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
		return person.getId();
	}

	public Person getPersonById(Integer id) {
		Person person = (Person)sessionFactory.getCurrentSession().get(Person.class, id);
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson() {
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}
	
	public void removePerson(Person person) {		
		if (person != null) {
			sessionFactory.getCurrentSession().delete(person);
		} else {
			throw new NullPointerException("No person to delete");
		}
	}
}
