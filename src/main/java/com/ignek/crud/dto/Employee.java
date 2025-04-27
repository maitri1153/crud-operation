package com.ignek.crud.dto;

public class Employee {
	private int id;
	private String fullName;
	private String email;
	private String gender;
	private String dob;
	private String hobby;

	public Employee(int id, String name, String email, String gender, String dob, String hobby) {
		this.id = id;
		this.fullName = name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.hobby = hobby;
	}

	public Employee(String name, String email, String gender, String dob, String hobby) {
		super();
		this.fullName = name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public String getHobby() {
		return hobby;
	}
}
