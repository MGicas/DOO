package edu.uco.budget.service.command.implementation;

import edu.uco.budget.crosscutting.exception.usecase.UseCaseCustomException;
import edu.uco.budget.crosscutting.execption.BudgetCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.command.CreatePersonCommand;
import edu.uco.budget.service.usecase.budget.CreatePersonUseCase;
import edu.uco.budget.service.usecase.budget.implementation.CreatePersonUseCaseImpl;

public class CreatePersonCommandImpl implements CreatePersonCommand{
	
	private DAOFactory factory;
	private final CreatePersonUseCase useCase = new CreatePersonUseCaseImpl(factory);

	@Override
	public void execute(PersonDTO person) {
		try {
			factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
			factory.initTransction();
			useCase.execute(person);
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
