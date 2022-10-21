package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;

public final class BudgetDTOBuilder {
	
	private UUID id;
	private PersonDTO person;
	private YearDTO year;
	
	private BudgetDTOBuilder() {
		super();
	}

	public static final BudgetDTOBuilder getBudgetDTObuilder() {
		return new BudgetDTOBuilder();
	}

	public final BudgetDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final BudgetDTOBuilder setPerson(final PersonDTO person) {
		this.person = person;
		return this;
	}

	public final BudgetDTOBuilder setYear(final YearDTO year) {
		this.year = year;
		return this;
	}
	
	public final BudgetDTO build() {
		return BudgetDTO.create(id, person, year);
	}
	
	
}
