package com.oozeander.model.collection_enum_map;

public enum Gender {
	MALE("Male"), FEMALE("Female");

	private String name;

	Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}