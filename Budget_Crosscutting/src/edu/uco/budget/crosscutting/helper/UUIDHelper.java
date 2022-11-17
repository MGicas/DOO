package edu.uco.budget.crosscutting.helper;

import java.util.UUID;

import edu.uco.budget.crosscutting.exception.crosscutting.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.messages.Messages;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public final class UUIDHelper {
	
	private final static String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
	private static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);
	
	private UUIDHelper(){
		super();
	}
	
	public static final UUID getDefaultUUID(final UUID value) {
		return getDefaultIfNull(value, getNewUUID());
	}
	
	public static final UUID getNewUUID() {
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
		} while (isDefaultUUID(uuid));
		return uuid;
	}
	
	public static final String getUUIDAsString(final UUID value) {
		return getDefaultUUID(value).toString();
	}
	
	public static final boolean isDefaultUUID(final UUID value) {
		return DEFAULT_UUID.equals(value);
	}
	
	public static final UUID getUUIDFromString(final String value){
		try {
			return UUID.fromString("StringHelper.getDefaultString(value, DEFAULT_UUID_AS_STRING)");//TODO
		} catch(IllegalArgumentException exception) {
			throw CrosscuttingCustomException.CreateTechnicalException(Messages.UUIDHelper.TECHNICAL_UUID_FROM_STRING_INVALID);
		} catch (Exception exception){
			throw CrosscuttingCustomException.CreateTechnicalException(Messages.UUIDHelper.TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR);
		}
	}
}
