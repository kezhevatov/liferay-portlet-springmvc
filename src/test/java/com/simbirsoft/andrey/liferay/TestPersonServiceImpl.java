package com.simbirsoft.andrey.liferay;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simbirsoft.andrey.liferay.model.Person;
import com.simbirsoft.andrey.liferay.service.PersonService;
import com.simbirsoft.andrey.liferay.vo.PersonVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-config.xml"})
public class TestPersonServiceImpl {

	@Autowired
	private PersonService personService;
	
	@Test
	public void addRecord(){
		PersonVO personVO = new PersonVO();
		personVO.setFirstName("FirstName");
		personVO.setLastName("LastName");
		personVO.setBirthday("2015-01-21");
		Person person = new Person(personVO);		
		Integer personId = personService.saveOrUpdatePerson(person);
		Assert.assertNull("Add record incorrect", personService.getPersonById(personId));		
	}	
}
