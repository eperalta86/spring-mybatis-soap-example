package com.esteban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.domain.PersonDomain;
import com.esteban.webservices.account.Account;
import com.esteban.webservices.account.EnumAccountStatus;
import com.esteban.service.PersonService;

/**
 * The Class AccountService.
 */
@Service
public class AccountServiceImpl implements AccountService
{
	
	@Autowired
	private PersonService personService;

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	public Account getAccountDetails(String accountNumber)
	{
		List<PersonDomain> persons = personService.getAllPerson();

		String message = persons.get(0).getName();
		

		/* hard coded account data - in reality this data would be retrieved
		 * from a database or back end system of some sort */
		Account account = new Account();
		account.setAccountNumber("12345");
		account.setAccountStatus(EnumAccountStatus.ACTIVE);
		account.setAccountName(message);
		account.setAccountBalance(3400);

		return account;
		
	}
}
