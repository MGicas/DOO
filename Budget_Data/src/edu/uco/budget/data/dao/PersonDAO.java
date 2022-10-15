package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;


public interface PersonDAO {
	
	void create(PersonDAO person);
	
	List<PersonDAO> find (PersonDAO person);
	
	void update(PersonDAO person);
	
	void delete(UUID id);

}
