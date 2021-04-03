package com.scratchdeveloper.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	
	@NotNull(message = "first Name cannot be null")
	@Size(min =2,message = "first name cannot be less than 2 and greater than 15" ,max=15)
	private String firstName;
	
	@NotNull(message = "last Name cannot be null")
	@Size(min =2,message = "last name cannot be less than 2 and greater than 15" ,max=15)
	private String lastName;
	
	@NotNull(message = "password cannot be null")
	@Size(min =8,message = "password cannot be less than 8 character and greater than 16" ,max=16)
	private String password;
	
	@NotNull(message="email cannot be null")
	@Email
	private String email;

	public CreateUserRequestModel() {
		super();
	}

	public CreateUserRequestModel(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CreateUserRequestModel [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + "]";
	}

}
