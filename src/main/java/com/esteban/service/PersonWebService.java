package com.esteban.service;

import com.esteban.webservices.person.Person;

public interface PersonWebService
{

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	public Person getPersonDetails();
}
