package edu.uco.budget.crosscutting.execption;

import edu.uco.budget.crosscutting.exception.enumeration.LayerException;
import edu.uco.budget.crosscutting.helper.StringHelper;
import static edu.uco.budget.crosscutting.helper.ObjectHelper. *;

public class BudgetCustomException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
    private String userMessage; 
    private  LayerException layer;
    
    protected BudgetCustomException(final String userMessage, final LayerException layer, final String technicalMessage, final Throwable rootException) {
        super(technicalMessage, getDefaultIfNull(rootException, new Exception()));
        setUserMessage(userMessage);
        setLayer(layer);
    }
      
	public final String getUserMessage() {
		return userMessage;
	}
	public final void setUserMessage(final String userMessage) {
		this.userMessage = StringHelper.applyTrim(userMessage);
	}
	public final LayerException getLayer() {
		return layer;
	}
	public final void setLayer(final LayerException layer) {
		this.layer = layer;
	}
    
	public final boolean isTechinalException() {
        return isNull(getUserMessage());
    }

}
