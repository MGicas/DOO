package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;


public interface YearDAO {

	void create(YearDAO year);
	
	List<YearDAO> find (YearDAO year);
	
	void update(YearDAO year);
	
	void delete(UUID id);
}
