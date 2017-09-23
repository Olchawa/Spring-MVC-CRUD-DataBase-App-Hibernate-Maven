package com.studentDb.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

	// fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = "Is required")
	@Size(min = 1, message = "This field is required")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "Is required")
	@Size(min = 1, message = "This field is required")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid format")
	@Column(name = "email")
	private String email;

	@NotNull(message = "This field is required")
	@Min(value = 0, message = "Enter positive number")
	@Max(value = 150, message = "Enter smaller number (max 150)")
	@Column(name = "age")
	private Integer age;

	@NotNull(message = "This field is required")
	@Size(min = 1, message = "This field is required")
	@Column(name = "country")
	private String country;

	@NotNull(message = "This field is required")
	@Size(min = 1, message = "This field is required")
	@Column(name = "city")
	private String city;

	// default constructor
	public Student() {

	}
	// getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", age=" + age + ", country=" + country + ", city=" + city + "]";
	}

}
