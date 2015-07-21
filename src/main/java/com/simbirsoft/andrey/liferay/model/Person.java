package com.simbirsoft.andrey.liferay.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.simbirsoft.andrey.liferay.vo.PersonVO;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 2713311358187074107L;

	@Id
	@Column(name = "ID")
	@GeneratedValue	
	private Integer id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "birthday", nullable = false)
	private Date birthday;

	public Person() {
	}

	public Person(PersonVO personVO) throws IllegalArgumentException {
		this.id = personVO.getId();
		this.firstName = personVO.getFirstName();
		this.lastName = personVO.getLastName();
		this.birthday = Date.valueOf(personVO.getBirthday().toString());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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
