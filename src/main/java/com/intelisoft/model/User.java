package com.intelisoft.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.intelisoft.model.enums.UserRole;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "users")
public class User extends Model{

	private static final long serialVersionUID = -6455789831431114570L;

	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", nullable = true)
	private Date birthDate;
	
	@Column(name = "phone_number", nullable = false)
	private Integer phoneNumber;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name = "e-mail", nullable = false)
	private String eMail;
	
	@Column(name = "user_role", nullable = false)
	private UserRole userRole;
	
	@ManyToMany
	@JoinTable(name = "users_current_courses",
	joinColumns = {@JoinColumn(name = "id_users")},
	inverseJoinColumns = {@JoinColumn(name = "id_current_courses")})
	private List<CurrentCourse> currentCourses = new ArrayList<CurrentCourse>();
	
	@OneToMany(mappedBy = "user")
	private List<CostCoefficient> costCoefficients = new ArrayList<CostCoefficient>();
	
	@ManyToMany
	@JoinTable(name = "users_complete_lessons",
	joinColumns = {@JoinColumn(name = "id_users")},
	inverseJoinColumns = {@JoinColumn(name = "id_complete_lessons")})
	private List<CompleteLesson> completeLessons = new ArrayList<CompleteLesson>();
	
	@ManyToOne
	@JoinColumn(name = "id_notiffications", referencedColumnName = "id")
	private Notiffication notiffication;

}