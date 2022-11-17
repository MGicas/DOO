package edu.uco.budget.service.usecase.person.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.usecase.pesron.FindPersonById;

public class FindPersonByIdImpl implements FindPersonById {
	
	private final DAOFactory factory;

	public FindPersonByIdImpl(DAOFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public PersonDTO execute(final UUID id) {
		
		final PersonDTO result = new PersonDTO();
		final PersonDTO person = PersonDTO.create(id);
		final List<PersonDTO> results = factory.getPersonDAO().find(person);
		
		if(!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
}
