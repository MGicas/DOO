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
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.YearDTO;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

public final class YearSQLServerDAO extends DAORelational implements YearDAO {

	public YearSQLServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(YearDTO year) {
		final var sql = "INSERT INTO Year(id, yearNumber) VALUES(?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, year.getIdAsString());
			preparedStatement.setShort(2, year.getYearNumber());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_CREATING_YEAR, exception);
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATING_YEAR, exception);
		}

	}

	@Override
	public List<YearDTO> find(YearDTO year) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, year, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final List<YearDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_YEAR, exception);
		}

	}

	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_YEAR, exception);
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_YEAR, exception);
		}
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT Ye.Id AS IdYear");
		sqlBuilder.append("       Ye.yearNumber AS YearNumber");
		sqlBuilder.append("FROM   Year Ye ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final YearDTO year, final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(year)) {
			if (!UUIDHelper.isDefaultUUID(year.getId())) {
				sqlBuilder.append("WHERE CompanyId = ? ");
				setWhere = false;
				parameters.add(year.getIdAsString());
			}
			if (!ObjectHelper.isNull(year.getYearNumber())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("name = ? ");
				setWhere = false;
				parameters.add(year.getYearNumber());
			}
		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY ");

	}

	private final List<YearDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_YEAR, exception);
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_YEAR, exception);
		}
	}

	@Override
	public void update(YearDTO year) {
		final var sql = "UPDATE Year SET id = ?, yearNumber = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, year.getIdAsString());
			preparedStatement.setShort(1, year.getYearNumber());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_UPDATE_YEAR,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_YEAR, exception);
		}

	}

	@Override
	public final void delete(final UUID id) {
		final var sql = "DELETE FROM year WHERE id = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, getUUIDAsString(id));

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_DELETE_YEAR,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_YEAR, exception);
		}

	}

	private final List<YearDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<YearDTO>();

			while (resultSet.next()) {

				results.add(fillYearDTO(resultSet));

			}

			return results;

		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_YEAR, exception);
		} catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_YEAR, exception);
		}

	}

	private final YearDTO fillYearDTO(final ResultSet resultSet) {

		try {
			return YearDTO.create(resultSet.getString("PersonId"), resultSet.getShort("PersonYearNumber"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_PROBLEM_FILLING_YEARDTO_YEAR, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.YearSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_YEARDTO_YEAR, exception);
		}
	}

}
