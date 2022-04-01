package com.esteban.service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.esteban.service.PersonWebService;
import com.esteban.webservices.person.Person;
import com.esteban.webservices.personservice.PersonDetailsRequest;
import com.esteban.webservices.personservice.PersonDetailsResponse;

/**
 * The Class AccountService.
 */
@Endpoint
public class PersonServiceEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/esteban/webservices/personservice";

	@Autowired
	private PersonWebService personService_i;

	@PayloadRoot(localPart = "PersonDetailsRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload PersonDetailsResponse getPersonDetails(@RequestPayload PersonDetailsRequest request)
	{
		PersonDetailsResponse response = new PersonDetailsResponse();

		Person person = personService_i.getPersonDetails();
		response.setPersonDetails(person);
		return response;
	}

	public void setPersonWebService(PersonWebService personService_p)
	{
		this.personService_i = personService_p;
	}
}