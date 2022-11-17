package edu.uco.budget.crosscutting.messages;

public class Messages {

	private Messages() {
		super();
	}

	public static class DAOFactory {

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
	
	public static class DAORelational {

		private DAORelational() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection already is closed";

	}

	public static class SqlConnectionHelper {

		private SqlConnectionHelper() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_ALREADY_IS_OPEN = "Connection already is open";
		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "There was a problem trying to close connection";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is closed to init the current transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection is closed to rollback the current transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed to commit the current transaction";
		public static final String TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION = "There was a problem trying to init transaction";
		public static final String TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION = "There was a problem trying to close connection";
		public static final String TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION = "There was a problem trying to rollback trasaction";
		public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init trasaction with the current connection in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_CLOSE_CONNECTION = "There was a problem trying to close connection with the current connection in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_CONFIRM_TRANSACTION = "There was a problem trying to confirm trasaction with the current connection in SQLServerDAOFactory";
	}

	public static class SqlServerFactory {

		private SqlServerFactory() {
			super();
		}
		public static final String TECHNICAL_CONNECTION_INIT_TRANSACTION = "There was a problem trying to init transaction with the connection in MySqlDAOFactory";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is already closed";
		public static final String TECHNICAL_CONNECTION_CLOSE_CONNECTION = "There was a problem trying to close connection with the current connection in MySqlDAOFactory";
		public static final String TECHNICAL_CONNECTION_CONFIRM_TRANSACTION = "There was a problem trying to confirm trasaction with the current connection in MySqlDAOFactory";
		public static final String TECHNICAL_CONNECTION_CONNECT_DATABASE = "There was a problem trying to connect to Data base ";
		public static final String TECHNICAL_CONNECTION_ROLLBACK_TRANSACTION = "There was a problem trying to rollback transaction";
		public static final String TECHNICAL_PROBLEM_CONNECT_DATABASE="There was a problem connecting the database";


	}

	public static class UUIDHelper {
		private UUIDHelper() {
			super();
		}

		public static final String TECHNICAL_UUID_FROM_STRING_INVALID = "The UUID to convert doesn't have a correct format";
		public static final String TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = "There was an unexpected error";
	}

	public static class BudgetSQLServerDAO {

		private BudgetSQLServerDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_BUDGET = "Connection is already closed";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET = "Connection is already closed";

		public static final String TECHNICAL_PROBLEM_CREATING_BUDGET = "There was a problem trying to create a budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_BUDGET = "There was an unexpected problem trying to create a budget";

		public static final String TECHNICAL_PROBLEM_UPDATE_BUDGET = "There was a problem trying to update budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET = "There was an unexpected problem trying to update budget";

		public static final String TECHNICAL_PROBLEM_DELETE_BUDGET = "There was a problem trying to delete budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET = "There was an unexpected problem trying to delete budget";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_BUDGET = "There was a problem trying to prepare and execute query of an budget";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_BUDGET= "There was a problem trying to setting parameters values of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_BUDGET = "There was an unexpected problem trying to setting parameters values of an budget";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_BUDGET = "There was a problem trying to execute query of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_BUDGET = "There was an unexpected problem trying to execute query of an budget";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_BUDGET = "There was a problem trying to fill results of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_BUDGET = "There was an unexpected problem trying to execute query of an budget";
		public static final String TECHNICAL_PROBLEM_FILLING_BUDGETDTO_BUDGET = "There was a problem trying to fill budgetDTO of an budget";
		public static final String TECHNICAL_PROBLEM_FILLING_PERSONDTO_BUDGET = "There was a problem trying to fill personDTO of an budget";
		public static final String TECHNICAL_PROBLEM_FILLING_YEARDTO_BUDGET = "There was a problem trying to fill yearDTO of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_BUDGETDTO_BUDGET = "There was a problem trying to fill lenderDTO of an budget";

	}
	
	public static class PersonSQLServerDAO {

		private PersonSQLServerDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATING_PERSON = "There was a problem trying to create a budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_PERSON = "There was an unexpected problem trying to create a budget";

		public static final String TECHNICAL_PROBLEM_UPDATE_PERSON = "There was a problem trying to update budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON = "There was an unexpected problem trying to update budget";

		public static final String TECHNICAL_PROBLEM_DELETE_PERSON = "There was a problem trying to delete budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON = "There was an unexpected problem trying to delete budget";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_PERSON = "There was a problem trying to prepare and execute query of an budget";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_PERSON= "There was a problem trying to setting parameters values of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_PERSON = "There was an unexpected problem trying to setting parameters values of an budget";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_PERSON = "There was a problem trying to execute query of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_PERSON = "There was an unexpected problem trying to execute query of an budget";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_PERSON = "There was a problem trying to fill results of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_PERSON = "There was an unexpected problem trying to execute query of an budget";
		public static final String TECHNICAL_PROBLEM_FILLING_PERSONDTO_PERSON = "There was a problem trying to fill budgetDTO of an budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_PERSONDTO_PERSON = "There was a problem trying to fill lenderDTO of an budget";

	}
	
	public static class YearSQLServerDAO {

		private YearSQLServerDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATING_YEAR = "There was a problem trying to create a year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_YEAR = "There was an unexpected problem trying to create a year";

		public static final String TECHNICAL_PROBLEM_UPDATE_YEAR = "There was a problem trying to update year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_YEAR = "There was an unexpected problem trying to update year";

		public static final String TECHNICAL_PROBLEM_DELETE_YEAR = "There was a problem trying to delete year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_YEAR = "There was an unexpected problem trying to delete year";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_YEAR = "There was a problem trying to prepare and execute query of an year";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_YEAR= "There was a problem trying to setting parameters values of an year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_YEAR = "There was an unexpected problem trying to setting parameters values of an year";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_YEAR = "There was a problem trying to execute query of an year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_YEAR = "There was an unexpected problem trying to execute query of an year";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_YEAR = "There was a problem trying to fill results of an year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_YEAR = "There was an unexpected problem trying to execute query of an year";
		public static final String TECHNICAL_PROBLEM_FILLING_YEARDTO_YEAR = "There was a problem trying to fill budgetDTO of an year";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_YEARDTO_YEAR = "There was a problem trying to fill lenderDTO of an year";

	}
	
	public static class UseCaseCommand {

		private UseCaseCommand() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATING_ADMIN = "There was a problem creating the admin, try again";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_ADMIN = "There was an unexpected problem creating the admin, try again";

		public static final String TECHNICAL_PROBLEM_CREATING_COMPANY = "There was a problem creating company, try again";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_COMPANY = "There was an unexpected problem creating company, try again";

	}
	
	public static class UseCaseImpl {

		private UseCaseImpl() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_PERSON_DOES_NOT_EXIST = "There person doesn't exist";
		public static final String TECHNICAL_PROBLEM_VALIDATE_ADMIN_FIRSTNAME = "There was a problem validating the firstname, obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_ADMIN_SECONDSURNAME = "Second surname is an obligatory data*";

		public static final String TECHNICAL_PROBLEM_VALIDATE_COMPANY_NAME = "The name is obligatory data*";

	}

}
