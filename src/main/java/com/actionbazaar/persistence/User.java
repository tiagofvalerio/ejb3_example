package com.actionbazaar.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;

public class User implements Serializable {

	private static final long serialVersionUID = 4858501322153257103L;

	private String firstName;

	private String lastName;

	private byte[] picture;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date birthDate;

	public User() {
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.toUpperCase();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
