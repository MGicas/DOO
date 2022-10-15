package edu.uco.budget.domain.builder;

import edu.uco.budget.domain.PersonDTO;

public final class PersonDTOBuilder {
	
	private String id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	private PersonDTOBuilder() {
		super();
	}
	
	public static final PersonDTOBuilder getPersonDTObuilder() {
		return new PersonDTOBuilder();
	}

	public PersonDTOBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public PersonDTOBuilder setIdCard(String idCard) {
		this.idCard = idCard;
		return this;
	}

	public PersonDTOBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonDTOBuilder setSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public PersonDTOBuilder setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
		return this;
	}

	public PersonDTOBuilder setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
		return this;
	}
	
	public final PersonDTO build() {
		return PersonDTO.create(id,idCard, firstName, secondName, firstSurname, secondSurname);
	}

	
}
