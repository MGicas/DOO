package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.PersonDTO;
import static edu.uco.budget.crosscutting.helper.StringHelper.isDefaultString;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

public class PersonSQLServerDAO extends DAORelational implements PersonDAO {

	public PersonSQLServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final PersonDTO person) {
		final var sql = "INSERT INTO Person(id, idCard, firstName, secondName, firstSurname, secondSurname) VALUES(?, ?, ?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, person.getIDAsString());
			preparedStatement.setString(2, person.getIdCard());
			preparedStatement.setString(3, person.getFirstname());
			preparedStatement.setString(3, person.getSecondName());
			preparedStatement.setString(3, person.getFirstSurname());
			preparedStatement.setString(3, person.getSecondSurname());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_CREATING_PERSON, exception);
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATING_PERSON, exception);
		}

	}

	@Override
	public List<PersonDTO> find(final PersonDTO person) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, person, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final List<PersonDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
			final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_PERSON, exception);
		}

	}

	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_PERSON, exception);
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_PERSON,
					exception);
		}
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT Pe.Id AS IdPerson");
		sqlBuilder.append("       Pe.idCard AS IdCard");
		sqlBuilder.append("       Pe.firstName AS FirstNamePerson");
		sqlBuilder.append("       Pe.secondName AS SecondNamePerson");
		sqlBuilder.append("       Pe.firstSurname AS FirstSurnamePerson");
		sqlBuilder.append("       Pe.secondSurname AS SecondSurnamePerson");
		sqlBuilder.append("FROM   Person Pe ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final PersonDTO person,
			final List<Object> parameters) {

		var setWhere = true;

		if (!ObjectHelper.isNull(person)) {
			if (!UUIDHelper.isDefaultUUID(person.getId())) {
				sqlBuilder.append("WHERE id = ? ");
				setWhere = false;
				parameters.add(person.getIDAsString());
			}

			if (!isDefaultString(person.getFirstname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstName = ? ");
				setWhere = false;
				parameters.add(person.getFirstname());
			}
			if (!isDefaultString(person.getSecondName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondName = ? ");
				setWhere = false;
				parameters.add(person.getSecondName());
			}
			if (!isDefaultString(person.getFirstSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstSurname = ? ");
				setWhere = false;
				parameters.add(person.getFirstSurname());
			}
			if (!isDefaultString(person.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondSurname = ? ");
				setWhere = false;
				parameters.add(person.getSecondSurname());
			}

		}

	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY ");

	}

	private final List<PersonDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_PERSON, exception);
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_PERSON, exception);
		}
	}

	@Override
	public final void update(final PersonDTO person) {

		final var sql = "UPDATE Person SET id = ?, idcard = ?, firstname = ?, secondname = ?, firstsurname = ?, secondsurname = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIDAsString());
			preparedStatement.setString(1, person.getIdCard());
			preparedStatement.setString(1, person.getFirstname());
			preparedStatement.setString(1, person.getSecondName());
			preparedStatement.setString(1, person.getFirstSurname());
			preparedStatement.setString(1, person.getSecondSurname());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_UPDATE_PERSON, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON, exception);
		}
	}

	@Override
	public final void delete(final UUID id) {

		final var sql = "DELETE FROM person WHERE id = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, getUUIDAsString(id));

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_DELETE_PERSON, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON, exception);
		}

	}

	private final List<PersonDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<PersonDTO>();

			while (resultSet.next()) {

				results.add(fillPersonDTO(resultSet));

			}

			return results;

		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_PERSON, exception);
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_PERSON, exception);
		}

	}

	private final PersonDTO fillPersonDTO(final ResultSet resultSet) {

		try {
			return PersonDTO.create(resultSet.getString("PersonId"), resultSet.getString("PersonIdCard"),
					resultSet.getString("PersonFirstName"), resultSet.getString("PersonSecondName"),
					resultSet.getString("PersonFirstSurname"), resultSet.getString("PersonSecondSurname"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_PROBLEM_FILLING_PERSONDTO_PERSON, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.PersonSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_PERSONDTO_PERSON, exception);
		}
	}

}
