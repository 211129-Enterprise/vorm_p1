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

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
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
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
