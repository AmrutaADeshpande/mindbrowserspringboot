

package com.rts.bo;

import java.io.Serializable;
import java.util.Date;

public class ManagerBo implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private Long managerId;
	
	private String firtName;
		
	private String lastName;
	
	private String address;
	
	private String password;
	
	private String email;	
	
	private Date dob;
	
	private String company;

	public Long getManagerId() {
		return managerId;
	}

	public String getFirtName() {
		return firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Date getDob() {
		return dob;
	}

	public String getCompany() {
		return company;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
}
