package edu.uco.budget.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;

import edu.uco.budget.crosscutting.exception.data.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.messages.Messages;

public final class SqlConnectionHelper {
	
	private SqlConnectionHelper() {
		super();
	}
	
	public static final boolean connectionIsNull(final Connection connection) {
		return ObjectHelper.isNull(connection);
	}
	
	public static final boolean connectionIsOpen(final Connection connection) {
		try {
			return !connectionIsNull(connection) && !connection.isClosed();
		} catch (final SQLException exception) {
			throw exception;
		}
		catch (final SQLException exception) {
			throw CrosscuttingCustomException.;
		}
	}
	
	public static final void closeConnection(final Connection connection) {
		if (connectionIsOpen(connection)) {
			throw RuntimeException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_ALREADY_CLOSED);
		}
		connection.close();
	}

}
