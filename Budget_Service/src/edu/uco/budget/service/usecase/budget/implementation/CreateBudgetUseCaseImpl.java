package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.service.usecase.budget.FindNextYearUseCase;
import edu.uco.budget.service.usecase.year.implementation.FindNextYearUseCaseImpl;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase{
	
private final DAOFactory factory;
private final FindNextYearUseCase findNextYearUseCase;
	
	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findNextYearUseCase = new FindNextYearUseCaseImpl(factory);
	}

	@Override
	public final void execute(final BudgetDTO budget) {
		
		YearDTO year = findNextYearUseCase.execute();
		
		factory.getBudgetDAO().create(budget);
	}

}
