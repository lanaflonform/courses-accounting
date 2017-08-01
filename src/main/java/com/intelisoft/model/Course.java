package com.intelisoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "courses")
public class Course extends Model {

	private static final long serialVersionUID = -3032038204901394998L;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cost", nullable = false)
	private Double cost;

	@Column(name = "duration_hours", nullable = false)
	private Float durationHours;

	@OneToMany(mappedBy = "course")
	private List<Lesson> lessons = new ArrayList<Lesson>();

	@OneToMany(mappedBy = "course")
	private List<CurrentCourse> currentCourses = new ArrayList<CurrentCourse>();

}
