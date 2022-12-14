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
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

public class BudgetSQLServerDAO extends DAORelational implements BudgetDAO{
	
	public BudgetSQLServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final void create(BudgetDTO budget) {
		final var sql = "INSERT INTO Budget(id, idCard, idPerson) VALUES(?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, budget.getIDAsString());
			preparedStatement.setString(2, budget.getYear().getIdAsString());
			preparedStatement.setString(3, budget.getPerson().getIDAsString());
			
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_CREATING_BUDGET, exception);
		}catch (final Exception exception) {
			throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET, exception);
		}
		}

	@Override
	public List<BudgetDTO> find (final BudgetDTO budget) {
		
		var parameters = new ArrayList<Object>();
        final var sqlBuilder = new StringBuilder();
		
		 createSelectFrom(sqlBuilder);
	     createWhere(sqlBuilder, budget, parameters);
	     createOrderBy(sqlBuilder);

	        return prepareAndExecuteQuery(sqlBuilder, parameters);
		}
		
	private final List<BudgetDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

        try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {
            
            setParametersValues(preparedStatement, parameters);

            return executeQuery(preparedStatement);
        } catch (Exception exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_BUDGET, exception);
        }

    }


    private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
        try {
            for(int index = 0; index < parameters.size(); index++){
                preparedStatement.setObject(index + 1, parameters.get(index));
            }
        } catch(final SQLException exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_BUDGET, exception);
        } catch(final Exception exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_BUDGET, exception);
        }
    }


    private final void createSelectFrom(final StringBuilder sqlBuilder){
        sqlBuilder.append("SELECT Bu.Id AS IdBudget");
        sqlBuilder.append("       Bu.idYear AS IdYear");
        sqlBuilder.append("       Ye.year AS NumberYear");
        sqlBuilder.append("       Bu.idPerson AS IdPerson");
        sqlBuilder.append("       Pe.idCard AS IdCard");
        sqlBuilder.append("       Pe.firstName AS FirstNamePerson");
        sqlBuilder.append("       Pe.secondName AS SecondNamePerson");
        sqlBuilder.append("       Pe.firstSurname AS FirstSurnamePerson");
        sqlBuilder.append("       Pe.secondSurname AS SecondSurnamePerson");
        sqlBuilder.append("FROM   Budget Bu ");
        sqlBuilder.append("INNER JOIN Year Ye ");
        sqlBuilder.append("ON     Bu.idYear = Ye.id ");
        sqlBuilder.append("INNER JOIN Person Pe ");
        sqlBuilder.append("ON     Bu.idPerson = Pe.id ");
    }

    private final void createWhere(final StringBuilder sqlBuilder, final BudgetDTO budget, final List<Object> parameters){

        var setWhere = true;

        if(!ObjectHelper.isNull(budget)){
            if (!UUIDHelper.isDefaultUUID(budget.getId())){
                sqlBuilder.append("WHERE id = ? ");
                setWhere = false;
                parameters.add(budget.getIDAsString());
            }

            if (!UUIDHelper.isDefaultUUID(budget.getYear().getId())){
                sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("idYear = ? ");
                setWhere = false;
                parameters.add(budget.getYear().getIdAsString());
            }

            if (!UUIDHelper.isDefaultUUID(budget.getPerson().getId())){
                sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("idPerson = ? ");
                parameters.add(budget.getPerson().getIDAsString());
            }

        }

    }

    private final void createOrderBy(final StringBuilder sqlBuilder){

        sqlBuilder.append("ORDER BY "); 
        sqlBuilder.append("ON     Bu.idYear = Ye.id "); 

    }

    private final List<BudgetDTO> executeQuery(PreparedStatement preparedStatement){

        try (final var resultSet = preparedStatement.executeQuery()) {
            return fillResults(resultSet);
        } catch(final SQLException exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_BUDGET, exception);
        } catch(final DataCustomException exception) {
            throw exception;
        } catch(final Exception exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_BUDGET, exception);
        }
    }

    @Override
    public final void update(final BudgetDTO budget) {
        final var sql = "UPDATE BUDGET SET id = ?, idyear = ?, idperson = ?";

        try (final var preparedStatement = getConnection().prepareStatement(sql)) {
            
            preparedStatement.setString(1, budget.getIDAsString());
            preparedStatement.setString(2, budget.getYear().getIdAsString());
            preparedStatement.setString(3, budget.getPerson().getIDAsString());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_UPDATE_BUDGET, exception);
        } catch (Exception exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET, exception);
        }
    }

    @Override
    public final void delete(final UUID id) {
        final var sql = "DELETE FROM BUDGET WHERE id = ?";

        try (final var preparedStatement = getConnection().prepareStatement(sql)) {
            
            preparedStatement.setString(1, getUUIDAsString(id));

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_DELETE_BUDGET, exception);
        } catch (Exception exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET, exception);
        }
    }

    private final List<BudgetDTO> fillResults(final ResultSet resultSet){

        try{

            var results = new ArrayList<BudgetDTO>();

            while(resultSet.next()){

                results.add(fillBudgetDTO(resultSet));

            }

            return results;

        } catch (final SQLException exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_BUDGET, exception);
        } catch (final Exception exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_BUDGET, exception);
        }

    }

    private final BudgetDTO fillBudgetDTO(final ResultSet resultSet){

        try {

        return BudgetDTO.create(resultSet.getString("idBudget"),fillPersonDTO(resultSet), fillYearDTO(resultSet));

        } catch(final SQLException exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_FILLING_BUDGETDTO_BUDGET, exception);
        } catch(final DataCustomException exception) {
            throw exception;
        } catch(final Exception exception){
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_BUDGETDTO_BUDGET, exception);
        }

    }

    private final YearDTO fillYearDTO(final ResultSet resultSet){

        try {

            return YearDTO.create(resultSet.getString("IdYear"), resultSet.getShort("NumberYear"));
        } catch (SQLException exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_FILLING_YEARDTO_BUDGET, exception);
        }
    }

    private final PersonDTO fillPersonDTO(final ResultSet resultSet){

        try {

            return PersonDTO.create(resultSet.getString("IdPerson"), 
                                    resultSet.getString("IdCard"), 
                                    resultSet.getString("FirstNamePerson"),
                                    resultSet.getString("SecondNamePerson"),
                                    resultSet.getString("FirstSurnamePerson"),
                                    resultSet.getString("SecondSurnamePerson"));
            
        } catch (SQLException exception) {
            throw DataCustomException.CreateTechnicalException(Messages.BudgetSQLServerDAO.TECHNICAL_PROBLEM_FILLING_PERSONDTO_BUDGET, exception);
        }

    }

}
