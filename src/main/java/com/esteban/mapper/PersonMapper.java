package com.esteban.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.esteban.domain.PersonDomain;


public interface PersonMapper {
	
	public void savePerson(PersonDomain person);
	public void updatePerson(PersonDomain person);
	public void deletePerson(int id);


	public List<PersonDomain> getAllPerson();
}
