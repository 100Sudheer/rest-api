/**
 * 
 */
package com.example.model.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Sudheer Kumar
 *
 */
public class User {

	private Integer id;
	
	@Size(min=2, max=100, message = "Name is too short")
	private String userName;
	
	@Past(message = "DOB should be in past")
	private Date dob;
	
	@Pattern(regexp = "[0-9]{10}" , message="Length should be 10")
	private String mobile;

	public User() {

	}

	public User(Integer id, String userName, Date dob, String mobile) {
		super();
		this.id = id;
		this.userName = userName;
		this.dob = dob;
		this.mobile = mobile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
