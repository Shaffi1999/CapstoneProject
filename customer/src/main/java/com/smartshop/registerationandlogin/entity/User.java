package com.smartshop.registerationandlogin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
	@Id
	@NotNull(message = "Id Can Not Be Null")
//	@Size(min=4,max=6,message="Please Enter Password Between the length 4 and 6")
	private int userId;
	@NotEmpty(message = "First Name Can Not Be Null")
	private String firstName;
	@NotEmpty(message = "Last Name Can Not Be Null")
	private String lastName;
	@NotEmpty(message = "DOB Can Not Be Null")
	private String dob;
	@NotEmpty(message = "Gender Can Not Be Null")
	private String gender;
	@NotEmpty(message = "Contact Number Can Not Be Null")
	private String contactNumber;
	@NotEmpty(message = "Email Can Not Be Null")
	private String email;
	@NotEmpty(message = "Password Can Not Be Null")
	private String password;
	@NotEmpty(message = "User Category Can Not Be Null")
	private String userCategory;
}
