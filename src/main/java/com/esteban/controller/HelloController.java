package com.esteban.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esteban.domain.PersonDomain;
import com.esteban.service.PersonService;
 

@Controller
@RequestMapping("/main")
public class HelloController {
	
	@Autowired
	private PersonService personService;
 
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		
		List<PersonDomain> persons = personService.getAllPerson();

		String message = persons.get(0).getName();
		System.out.println(message);

		return new ModelAndView("welcome", "message", message);
		
	}
	
	@RequestMapping("/save")
	public ModelAndView save() {
		
		PersonDomain person = new PersonDomain();
		person.setAge("2");
		person.setSex("2");
		person.setName("12");
		person.setStandard("2");
		
		personService.savePerson(person);

		String message = "saved";
	
		return new ModelAndView("save", "message", message);
		
	}
	
	@RequestMapping("/delete")
	public String delete() {
		
		personService.deletePerson(6);
		System.out.println("deleted");

		return "deleted";
		
	}
}