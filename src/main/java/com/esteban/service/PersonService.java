package com.esteban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esteban.domain.PersonDomain;
import com.esteban.mapper.PersonMapper;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonMapper personMapper;

	public List<PersonDomain> getAllPerson() {
		return personMapper.getAllPerson();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void savePerson(PersonDomain person) {
		personMapper.savePerson(person);
	}
	
	@Transactional
	public void deletePerson(int id) {
		personMapper.deletePerson(id);
	}

}
