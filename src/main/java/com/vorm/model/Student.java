package com.vorm.model;

import java.util.Objects;

import com.vorm.annotations.Column;
import com.vorm.annotations.Entity;
import com.vorm.annotations.Id;

@Entity(tableName = "students")
public class Student {

	@Id(columnName = "student_id")
	private int id;
	
	@Column(columnName = "student_name")
	private String name;
	
	@Column(columnName = "student_last_name")
	private String lastName;
	
	@Column(columnName = "pin")
	private int pin;

	public Student() {
		super();
	}

	
	
	public Student(String name, String lastName, int pin) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.pin = pin;
	}



	public Student(int id, String name, String lastName, int pin) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.pin = pin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastName, name, pin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& pin == other.pin;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", pin=" + pin + "]";
	}


	
	
}
