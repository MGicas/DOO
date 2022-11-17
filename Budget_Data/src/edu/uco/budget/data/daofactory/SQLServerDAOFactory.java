package edu.uco.budget.data.daofactory;

import java.sql.Connection;

import edu.uco.budget.crosscutting.exception.crosscutting.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSQLServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSQLServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSQLServerDAO;

final class SQLServerDAOFactory extends DAOFactory{
	
	private Connection connection;
	
	SQLServerDAOFactory(){
		openConnection();
		initTransction();
	}

	@Override
	protected void openConnection() {
		connection = null;
		
	}

	@Override
	public void initTransction() {
		try {
			SqlConnectionHelper.initTrasaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.SqlServerFactory.TECHNICAL_CONNECTION_INIT_TRANSACTION, exception);
		}
	}

	@Override
	public void confirmTransaction() {
		try {
			SqlConnectionHelper.commitTrasaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.SqlServerFactory.TECHNICAL_CONNECTION_CONFIRM_TRANSACTION, exception);
		}
	}

	@Override
	public void cancelTransaction() {
		try {
			SqlConnectionHelper.rollbackTrasaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.SqlServerFactory.TECHNICAL_CONNECTION_ROLLBACK_TRANSACTION, exception);
		}
	}

	@Override
	public void closeTransaction() {
		try {
			SqlConnectionHelper.closeConnection(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.SqlServerFactory.TECHNICAL_CONNECTION_CLOSE_CONNECTION, exception);
		}
	}

	@Override
	public BudgetDAO getBudgetDAO() {
		return new BudgetSQLServerDAO(connection);
	}

	@Override
	public PersonDAO getPersonDAO() {
		return new PersonSQLServerDAO(connection);
	}

	@Override
	public YearDAO getYearDAO() {
		return new YearSQLServerDAO(connection);
	}
	

}
