package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.DAORelational;

public final class YearSQLServerDAO extends DAORelational implements YearDAO{

	public YearSQLServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final YearDAO year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<YearDAO> find(final YearDAO year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(final YearDAO year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final UUID id) {
		// TODO Auto-generated method stub
		
	}

}
