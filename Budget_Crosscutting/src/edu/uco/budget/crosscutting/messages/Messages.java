package edu.uco.budget.crosscutting.messages;

public class Messages {
	
	private Messages() {
		super();
	}
	
	public static class DAOFactory{
		
		private DAOFactory() {
			super();
		}
		
		public static final String TECHNICAL_MONGODB_NOT_IMPLEMENTED = "DAOFactory Mongobd is not implemented yet";
		public static final String TECHNICAL_CASSANDRA_NOT_IMPLEMENTED = "DAOFactory Cassandra is not implemented yet";
		public static final String TECHNICAL_MARIADB_NOT_IMPLEMENTED = "DAOFactory Mariadb is not implemented yet";
		public static final String TECHNICAL_ORACLE_NOT_IMPLEMENTED = "DAOFactory Oracle is not implemented yet";
		public static final String TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED = "DAOFactory Postgresql is not implemented yet";
		public static final String TECHNICAL_MYSQL_NOT_IMPLEMENTED = "DAOFactory Mysql is not implemented yet";
		public static final String TECHNICAL_UNEXPECTED_DAOFACTORY = "Unexpected DAOFactor is not implemented yet";
		
	}
	
	public static class SqlConnectionHelper{
		
		private SqlConnectionHelper() {
			super();
		}
		
		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_IS_ALREADY_CLOSED = "Connection is already closed";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is already closed";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMINT_TRANSACTION = "Connection is already closed";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection is already closed";
		public static final String TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION = "There was a problem traying to init the transaction";
		public static final String TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION = "Connection is already closed";
		public static final String TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION = "Connection is already closed";
	}
	
public static class SqlServerFactory{
		
		private SqlServerFactory() {
			super();
		}
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is already closed";
		
		
	}

public static class BudgetSqlServerDAO{
	
	private BudgetSqlServerDAO() {
		super();
	}
	public static final String TECHNICAL_PROBLEM_CREATE_BUDGET = "Connection is already closed";
	public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET = "Connection is already closed";
	
}

}
