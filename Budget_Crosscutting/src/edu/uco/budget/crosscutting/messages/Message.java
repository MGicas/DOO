package edu.uco.budget.crosscutting.messages;

import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.messages.enumeration.MessageLevel;

public final class Message {
	
	private MessageLevel level;
	private String content;
	
	public Message() {
		setLevel();
	}

	public Message(MessageLevel level, String content) {
		super();
		setLevel(level);
		setContent(content);
	}
	
	public static Message createFatalMessage(final String content) {
		return new Message(MessageLevel.FATAL, content);
	}
	
	public static Message createErrorMessage(final String content) {
		return new Message(MessageLevel.ERROR, content);
	}

	public static Message createInfoMessage(final String content) {
		return new Message(MessageLevel.INFO, content);
	}
	
	public static Message createWarningMessage(final String content) {
		return new Message(MessageLevel.WARNING, content);
	}
	
	public static Message createSuccessMessage(final String content) {
		return new Message(MessageLevel.SUCCESS, content);
	}
	
	public final MessageLevel getLevel() {
		return level;
	}

	public final void setLevel(MessageLevel level) {
		this.level = ObjectHelper.getDefaultIfNull(level, MessageLevel.FATAL);
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.level = ObjectHelper.getDefaultIfNull(level, MessageLevel.FATAL);
	}
	
	

}
