package edu.uco.budget.crosscutting.exception.usecase;

import edu.uco.budget.crosscutting.exception.enumeration.LayerException;
import edu.uco.budget.crosscutting.execption.BudgetCustomException;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

public class UseCaseCustomException extends BudgetCustomException{
	
	private static final long serialVersionUID = -3691429994161697127L;

	protected UseCaseCustomException(String userMessage, String technicalMessage, Throwable rootException) {
		super(userMessage,LayerException.SERVICE, technicalMessage, rootException );
	}

	public static final BudgetCustomException CreateUserException(final String userMessage) {
	    return new UseCaseCustomException(userMessage, userMessage, new Exception());
	    
	}
	
	public static final BudgetCustomException CreateTechnicalException(final String technicalMessage) {
	    return new UseCaseCustomException(EMPTY, technicalMessage, new Exception());
	    
	}
	public static final BudgetCustomException CreateTechnicalException(final String technicalMessage, final Exception rootException) {
	    return new UseCaseCustomException(EMPTY, technicalMessage,rootException);
	    
	}
	public static final BudgetCustomException CreateBusinessException(final String businessMessage, final Exception rootException) {
	    return new UseCaseCustomException(businessMessage, EMPTY,rootException);
	    
	}
	public static final BudgetCustomException Create(final String userMessage, final String technicalMessage) {
	    return new UseCaseCustomException(userMessage, technicalMessage, new Exception());
	    
	}
	public static final BudgetCustomException Create(final String userMessage, final String technicalMessage, final Exception rootException ) {
	    return new UseCaseCustomException(userMessage, technicalMessage, rootException);
	}
	public static final BudgetCustomException wrapException(final String message, final BudgetCustomException exception){
            if(exception.isTechinalException()){
                return UseCaseCustomException.CreateBusinessException(message, exception);
            }
            return exception;
	}

}
