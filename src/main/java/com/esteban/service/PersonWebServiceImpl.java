package com.esteban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.domain.PersonDomain;
import com.esteban.webservices.person.Person;


@Service
public class PersonWebServiceImpl implements PersonWebService
{
	
	@Autowired
	private PersonService personService;


	@Override
	public Person getPersonDetails() {
		List<PersonDomain> persons = personService.getAllPerson();

		String message = persons.get(0).getName();
		

		/* hard coded account data - in reality this data would be retrieved
		 * from a database or back end system of some sort */
		Person account = new Person();

		account.setName(message);
		account.setAge("20");
		account.setId("1");
		account.setSex("salvaje");
		account.setStandard("wii");
		
		return account;


	}
}
