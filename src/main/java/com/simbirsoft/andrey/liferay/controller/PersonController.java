package com.simbirsoft.andrey.liferay.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

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
	public String personEdit(@RequestParam(value = "personId", required = false) Integer personId, Model model) {
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
}
