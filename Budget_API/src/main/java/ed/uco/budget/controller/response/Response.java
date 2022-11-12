package ed.uco.budget.controller.response;

import java.util.ArrayList;
import java.util.List;

import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.messages.Message;

public class Response <T>{
	
	private List<Message> message;
	private List<T> data;
	
	public Response() {
		setMessage(new ArrayList<>());
		setData(new ArrayList<>());
	}
	
	public Response(List<Message> messages, List<T> data) {
		super();
		setMessage(messages);
		setData(data);
	}
	public final List<Message> getMessage() {
		return message;
	}
	public final void setMessage(List<Message> messages) {
		this.message = ObjectHelper.getDefaultIfNull(messages, new ArrayList<>());
	}
	public final List<T> getData() {
		return data;
	}
	public final void setData(List<T> data) {
		this.data = ObjectHelper.getDefaultIfNull(data, new ArrayList<>());
	}
	
	public void addFatalError(final String content) {
		getMessage().add(Message.createFatalMessage(content));
	}
	
	public void addError(final String content) {
		getMessage().add(Message.createErrorMessage(content));
	}
	
	public void addInfoError(final String content) {
		getMessage().add(Message.createInfoMessage(content));
	}
	
	public void addWarningError(final String content) {
		getMessage().add(Message.createWarningMessage(content));
	}

}
