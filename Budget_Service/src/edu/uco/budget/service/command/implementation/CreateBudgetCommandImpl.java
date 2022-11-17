package edu.uco.budget.service.command.implementation;

import edu.uco.budget.crosscutting.exception.usecase.UseCaseCustomException;
import edu.uco.budget.crosscutting.execption.BudgetCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.service.usecase.budget.implementation.CreateBudgetUseCaseImpl;

public class CreateBudgetCommandImpl implements CreateBudgetCommand {
	
	private DAOFactory factory;
	private final CreateBudgetUseCase useCase = new CreateBudgetUseCaseImpl(factory); 

	@Override
	public void execute(BudgetDTO budget) {

		try {
			factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
			factory.initTransction();
			useCase.execute(budget);
			factory.confirmTransaction();
		} catch (UseCaseCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (BudgetCustomException exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.wrapException(Messages.UseCaseCommand.TECHNICAL_PROBLEM_CREATING_ADMIN,
					exception);
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.CreateBusinessException(
					Messages.UseCaseCommand.TECHNICAL_UNEXPECTED_PROBLEM_CREATING_ADMIN, exception);
		} finally {
			factory.closeTransaction();
		}
		
	}

}
