package edu.uco.budget.data.daofactory;

import java.sql.Connection;

import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
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
		// EL
	}

	@Override
	public void confirmTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeTransaction() {
		// TODO Auto-generated method stub
		
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
