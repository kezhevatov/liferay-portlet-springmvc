package com.simbirsoft.andrey.liferay.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.simbirsoft.andrey.liferay.model.Person;
import com.simbirsoft.andrey.liferay.service.PersonService;

@Controller("personController")
@RequestMapping("VIEW")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RenderMapping
	public String defaultRender(Locale locale,  Model model) {		
		Person person = new Person();
		person.setFirstName("TestFirstName");
		person.setLastName("TestLastName");
		person.setBirthday(new Date());	
		personService.saveOrUpdatePerson(person);
		
		Person person2 = new Person();
		person2.setFirstName("TestFirstName2");
		person2.setLastName("TestLastName2");
		person2.setBirthday(new Date());	
		personService.saveOrUpdatePerson(person2);
		
		List<Person> persons = personService.getAllPerson();
		model.addAttribute("persons", persons);
		return "list";
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@RenderMapping(params = "render=edit")
	public String editPerson(@RequestParam(value = "personId", required = false) Integer personId, Model model) {
	    logger.debug("in addPerson()");
	    Person person = null;
	    if (personId != null) {

	    	logger.info("person id is " + personId);
	    	person = personService.getPersonById(personId);
	    }
	    if (person == null) {
	    	person = new Person();
	    }

	    model.addAttribute("person", person);
	    return "edit";
	  }
	
	@RenderMapping(params = "render=view")
	public String viewPerson(@RequestParam(value = "personId", required = false) Integer personId,
		      Map<String, Object> map) {
	
		Person person = null;
		if (personId != null) {
			logger.info("person id is " + personId);
			person = personService.getPersonById(personId);
		}
		if (person != null) {
			map.put("person", person);
		}
		return "view";
	}
	
	@ActionMapping(params = "action=save")
	  public void savePerson(ActionRequest actionRequest, ActionResponse actionResponse, Model model,
	      @ModelAttribute("person") Person person, BindingResult result) throws IOException,
	      PortletException {
	    logger.debug("In adddPerson()");


	    try {
	    	personService.saveOrUpdatePerson(person);
	    } catch (Exception e) {
	    	logger.error("Error while saving person", e);
	    }
	  }	
	
	@RenderMapping(params = "render=delete")
	  public String deletePerson(@RequestParam("personId") Integer personId, Model model) throws IOException {

	    try {
	      personService.removePerson(personId);
	    } catch (Exception e) {
	      logger.error("Error while deleting student", e);	      
	    }	 
	    return "list";
	  }
}
