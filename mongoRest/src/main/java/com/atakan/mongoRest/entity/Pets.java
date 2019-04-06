package com.atakan.mongoRest.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Pets {

	@NotBlank
	@NotNull
	private String name;
	
	@Min(value=1)
	private int age;
	
	@NotBlank
	@NotNull
	private String species;
	
	private Pets() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}


	
}
