package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class PersonDTO {
	
	private UUID id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	private PersonDTO(final UUID id, final String idCard, final String firstName, final String secondName, final String firstSurname, final String secondSurname){
		setId(getDefaultUUID(getId()));
		setIdCard(idCard);
		setFirstname(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static PersonDTO create(UUID id, String idCard, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new PersonDTO(id, idCard, firstName, secondName, firstSurname, secondSurname);
	}
	
	public static final PersonDTO create(String id, String idCard, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new PersonDTO(getUUIDFromString(id), idCard, firstName, secondName, firstName, secondSurname);
	}
	
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final void setIdCard(final String idCard) {
		this.idCard = (idCard == null)? " " : idCard.trim();
	}

	public final void setFirstname(String firstName) {
		this.firstName = (firstName == null)? " " : firstName.trim();
	}

	public final void setSecondName(String secondName) {
		this.secondName = (secondName == null)? " " : secondName.trim();
	}

	public final void setFirstSurname(String firstSurname) {
		this.firstSurname = (firstSurname == null)? " " : firstSurname.trim();
	}
	
	public final void setSecondSurname(String secondSurname) {
		this.secondSurname = (secondSurname == null)? " " : secondSurname.trim();
	}


	public final UUID getId() {
		return id;
	}

	public final String getIdCard() {
		return idCard;
	}

	public final String getFirstname() {
		return firstName;
	}

	public final String getSecondName() {
		return secondName;
	}

	public final String getFirstSurname() {
		return firstSurname;
	}
	
	public final String getSecondSurname() {
		return secondSurname;
	}
	
	public final String getSurname() {
		return getFirstSurname()+" " + getSecondSurname().trim();
	}
	
	public final String getName() {
		return getFirstname()+" " + getSecondName().trim() + " " + getSurname();
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}

}
