package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.BudgetDTO;

public class BudgetSQLServerDAO extends DAORelational implements BudgetDAO{
	
	public BudgetSQLServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final void create(BudgetDTO budget) {
		final var sql = "INSERT INTO Budget(id, idCard, idPerson) VALUES(?, ?, ?)";
		try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, budget.getIDAsString());
			preparedStatement.setString(2, budget.getYear().getIDAsString());
			preparedStatement.setString(3, budget.getPerson().getIDAsString());
			
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String message = (Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_CREATE.concat(budget.getIDAsString()));
			throw DataCustomException.createTechnicalException(null, exception);
		}catch (final Exception exception) {
			String message = (Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET.concat(budget.getIDAsString()))
		}
		}

	@Override
	public List<BudgetDTO> find (final BudgetDTO budget) {
		
		var setWhere = true;
		var parameters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT Bu.id AS IdBudget, ");
		sqlBuilder.append("FROM Budget Bu");
		
		if(!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefaultUUID(budget.getId())) {
				sqlBuilder.append("WHERE BU.id = ?");
				setWhere = false;
				parameters.add(budget.getIDAsString())
			}
			if (!UUIDHelper.isDefaultUUID(budget.getYear().getId())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND").append("WHERE idYear = ?");
				parameters.add(budget.getYear().getIDAsString())
			}
			if (!UUIDHelper.isDefaultUUID(budget.getPerson().getId())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND").append("WHERE idPerson = ?");
				parameters.add(budget.getPerson().getIDAsString());
			}
			
			sqlBuilder.append("ORDER BY Pe.idCard ASC,");
			try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){
				for (int index = 0; index < parameters.size(); index++) {
					preparedStatement.setObject(index + 1, parameters.get(index));
				}
				try(final var resultSet = preparedStatement.executeQuery()){
					
				}
			} catch (SQLException exception) {
				// TODO: handle exception
			}catch (SQLException exception) {
				// TODO: handle exception
			}
		}
		
		return null;
		}

	@Override
	public final void update(final BudgetDTO budget) {
		final var sql = "UPDATE Budget SET year = ?, person = ?";
		try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, budget.getYear().getIDAsString());
			preparedStatement.setString(2, budget.getPerson().getIDAsString());
			preparedStatement.setString(3, budget.getIDAsString());
			
		} catch (Exception exception) {
			// TODO: handle exception
		}
		
	}

	@Override
	public final void delete(final UUID id) {
		// TODO Auto-generated method stub
		
	}

}
