package com.simbirsoft.andrey.liferay.vo;

import com.simbirsoft.andrey.liferay.model.Person;

public class PersonVO {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String birthday;

	public PersonVO() {
	}
	
	public PersonVO(Person person) {
		if (person != null) {
			this.id = person.getId();
			this.firstName = person.getFirstName();
			this.lastName = person.getLastName();
			this.birthday = person.getBirthday().toString();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
