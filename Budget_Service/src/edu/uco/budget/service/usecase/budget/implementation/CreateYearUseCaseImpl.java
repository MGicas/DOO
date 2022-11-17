package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.budget.CreateYearUseCase;

public final class CreateYearUseCaseImpl implements CreateYearUseCase {
	
	private final DAOFactory factory;

	public CreateYearUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public final void execute(final YearDTO year) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getYearDAO().create(year);

	}
}
