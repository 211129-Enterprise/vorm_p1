package com.vorm.model;

import com.vorm.annotations.Column;
import com.vorm.annotations.Entity;
import com.vorm.annotations.Id;

@Entity(tableName  = "course")
public class Course {
	
	@Id(columnName = "course_id")
	private int id;
	
	@Column(columnName = "course_name")
	private String courseName;
	
	
	

}
