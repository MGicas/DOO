package edu.uco.budget.data.daofactory;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.enumeration.DAOFactoryType;

public abstract class DAOFactory {

	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {

		DAOFactory daoFactory;

		switch (factory) {
		case SQLSERVER:
			daoFactory = new SQLServerDAOFactory();
			break;
		case CASSANDRA:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENTED);
		case MARIADB:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENTED);
		case MONGODB:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_MONGODB_NOT_IMPLEMENTED);
		case ORACLE:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_ORACLE_NOT_IMPLEMENTED);
		case MYSQL:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENTED);
		case POSTGRESQL:
			throw DataCustomException
					.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED);

		default:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
		}

		return daoFactory;
	}

	protected abstract void openConnection();

	public abstract void initTransction();

	public abstract void confirmTransaction();

	public abstract void cancelTransaction();

	public abstract void closeTransaction();

	public abstract BudgetDAO getBudgetDAO();

	public abstract PersonDAO getPersonDAO();

	public abstract YearDAO getYearDAO();
}
