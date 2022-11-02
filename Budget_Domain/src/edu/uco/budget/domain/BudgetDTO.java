package edu.uco.budget.domain;

import java.util.UUID;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.budget.domain.builder.PersonDTOBuilder.getPersonDTObuilder;
import static edu.uco.budget.domain.builder.YearDTOBuilder.getYearDTObuilder;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDFromString;

public final class BudgetDTO {
	
	private UUID id;
	private PersonDTO person;
	private YearDTO year;
	
	public BudgetDTO() {
		setId(getNewUUID());
	}

	public BudgetDTO(final UUID id, final PersonDTO person, final YearDTO year) {
		setId(id);
		setPerson(person);
		setYear(year);
	}

	public static final BudgetDTO create(final UUID id, final PersonDTO person, final YearDTO year) {
		return new BudgetDTO(id, person, year);
	}
	
	public static final BudgetDTO create(final String id, final PersonDTO year, final YearDTO person){
        return new BudgetDTO(getUUIDFromString(id), year, person);
    }


	public final UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	public final PersonDTO getPerson() {
		return person;
	}
	public final void setPerson(PersonDTO person) {
		this.person = getDefaultIfNull(person, getPersonDTObuilder().build());
	}
	public final YearDTO getYear() {
		return year;
	}
	public final void setYear(final YearDTO year) {
		this.year = getDefaultIfNull(year, getYearDTObuilder().build());
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(getId());
	}

}
