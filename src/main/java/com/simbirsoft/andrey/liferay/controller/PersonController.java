package com.simbirsoft.andrey.liferay.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.simbirsoft.andrey.liferay.model.Person;
import com.simbirsoft.andrey.liferay.service.PersonService;

@Controller
@RequestMapping("VIEW")
public class PersonController {
		
	@Autowired
	private PersonService personService;
	
	@RenderMapping
	public String defaultRender(Locale locale,  Model model) {		
		List<Person> persons = personService.getAllPerson();
		
		Person person = new Person();
		person.setFirstName("Asd");
		person.setLastName("Cfdsd");
		personService.saveOrUpdatePerson(person);
		model.addAttribute("persons", persons);
		return "list";
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}
