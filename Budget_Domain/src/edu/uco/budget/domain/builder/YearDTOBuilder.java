package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.YearDTO;

public final class YearDTOBuilder {
	
	private UUID id;
	private short yearNumber;
	
	private YearDTOBuilder() {
		super();
	}
	
	public static final YearDTOBuilder getYearDTObuilder() {
		return new YearDTOBuilder();
	}
	
	
	public YearDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}
	public YearDTOBuilder setYearNumber(short yearNumber) {
		this.yearNumber = yearNumber;
		return this;
	}
	
	public final YearDTO build() {
		return YearDTO.create(id, yearNumber);
	}
	
	

}
