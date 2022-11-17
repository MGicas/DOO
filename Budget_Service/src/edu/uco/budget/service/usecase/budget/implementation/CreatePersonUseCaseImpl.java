package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.usecase.budget.CreatePersonUseCase;

public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

	private final DAOFactory factory;

	public CreatePersonUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void execute(PersonDTO person) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getPersonDAO().create(person);

	}
}
