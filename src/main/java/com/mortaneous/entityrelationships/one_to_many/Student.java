package com.mortaneous.entityrelationships.one_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "one_to_many_Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_number")
	private int studentNumber;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@ManyToOne
	private University university;

	public Student() {
	}

	public Student(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		University oldUniv = this.university;
		this.university = university;
		
		// remove from previous university
		if(oldUniv != null) {
			oldUniv.removeStudent(this);
		}
		
		// add to new university
		if(university != null) {
			university.addStudent(this);
		}
	}
	
	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}

}
