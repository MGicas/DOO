package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;

public class PersonSQLServerDAO extends DAORelational implements PersonDAO{

	public PersonSQLServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final PersonDAO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDAO> find(final PersonDAO person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(final PersonDAO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final UUID id) {
		// TODO Auto-generated method stub
		
	}

}
