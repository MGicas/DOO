package ed.uco.budget.controller.validator.budget;

import java.util.List;
import java.util.UUID;

import ed.uco.budget.controller.validator.Validator;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Message;

public class CreateBudgetValidator implements Validator<BudgetDTO>{
	
	private void validatePersonID(UUID personId, List<Message> message) {
		if(UUIDHelper.isDefaultUUID(personId)) {
			message.add(Message.createErrorMessage(""));
		}
	}

}
