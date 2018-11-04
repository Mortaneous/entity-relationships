package com.mortaneous.entityrelationships.one_to_one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="one_to_one_address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String street;
	private String city;
	private String country;
	private String zip;

	@OneToOne
	//@JoinColumn(name="emp_id")		// <--- FK column name in the Address table
	private Employee employee;
	
	public Address() {
	}

	public Address(String street, String city, String country, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
