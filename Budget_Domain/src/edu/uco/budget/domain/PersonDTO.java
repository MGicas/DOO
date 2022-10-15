package edu.uco.budget.domain;

public class PersonDTO {
	
	private String id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	private PersonDTO(final String id, final String idCard, final String firstName, final String secondName, final String firstSurname, final String secondSurname){
		setId(id);
		setIdCard(idCard);
		setFirstname(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static PersonDTO create(String id, String idCard, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new PersonDTO(id, idCard, firstName, secondName, firstSurname, secondSurname);
	}
	
	private final void setId(String id) {
		this.id = (id == null)? " " : id.trim();
	}

	private final void setIdCard(String idCard) {
		this.idCard = (idCard == null)? " " : idCard.trim();
	}

	private final void setFirstname(String firstName) {
		this.firstName = (firstName == null)? " " : firstName.trim();
	}

	private final void setSecondName(String secondName) {
		this.secondName = (secondName == null)? " " : secondName.trim();
	}

	private final void setFirstSurname(String firstSurname) {
		this.firstSurname = (firstSurname == null)? " " : firstSurname.trim();
	}
	
	private final void setSecondSurname(String secondSurname) {
		this.secondSurname = (secondSurname == null)? " " : secondSurname.trim();
	}


	public final String getId() {
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
	
	

}
