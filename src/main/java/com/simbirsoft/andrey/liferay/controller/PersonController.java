package com.simbirsoft.andrey.liferay.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.simbirsoft.andrey.liferay.model.Person;
import com.simbirsoft.andrey.liferay.service.PersonService;
import com.simbirsoft.andrey.liferay.util.PersonUtil;
import com.simbirsoft.andrey.liferay.vo.PersonVO;

@Controller("personController")
@RequestMapping("VIEW")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RenderMapping
	public String defaultRender(Locale locale,  Model model) {					
		List<Person> persons = personService.getAllPerson();
		List<PersonVO> personsVO = PersonUtil.getPersonVOList(persons);
		model.addAttribute("persons", personsVO);
		return "list";
	}
	
	@RenderMapping(params = "render=edit")
	public String editPerson(@RequestParam(value = "personId", required = false) Integer personId, Model model) {
	    logger.debug("in addPerson()");
	    Person person = null;
	    if (personId != null) {
	    	person = personService.getPersonById(personId);	    	
	    }
	    PersonVO personVO = new PersonVO(person);
	    model.addAttribute("person", personVO);
	    return "edit";
	  }
	
	@RenderMapping(params = "render=view")
	public String viewPerson(@RequestParam(value = "personId", required = false) Integer personId,	Model model) {
		Person person = null;
		PersonVO personVO = null;
		if (personId != null) {
			person = personService.getPersonById(personId);
			personVO = new PersonVO(person);			
		}
		model.addAttribute("person", personVO);
		return "view";
	}
	
	@ActionMapping(params = "action=save")
	public void savePerson(@ModelAttribute("person") PersonVO personVO) {
		try {
			Person	person = new Person(personVO);			
			personService.saveOrUpdatePerson(person);
		} catch (Exception e) {
			logger.error("Error while saving person", e);
		}
	}
	
	@RenderMapping(params = "render=delete")
	public String deletePerson(@RequestParam(value = "personId", required = false) Integer personId, Model model) {
	    Person person = null;
	    PersonVO personVO = null;
	    if (personId != null) {
	    	person = personService.getPersonById(personId);
	    	personVO = new PersonVO(person);
	    }
	    model.addAttribute("person", personVO);
	    return "delete";
	  }
	
	@ActionMapping(params = "action=delete")
	public void removePerson(@ModelAttribute("person") PersonVO personVO) {
		try {
			Person person = personService.getPersonById(personVO.getId());
			personService.removePerson(person);
		} catch (Exception e) {
			logger.error("Error while delete person", e);
		}
	}
}
