/**
 * 
 */
package com.rts.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="dob")
	private Date dob;

	@Column(name = "mobile" , unique = true, length=20)
	private String mobile;
	
	@Column(name="city")
	private String city;
	
	@Transient
	private String dobStr;

	public Long getEmpId() {
		return empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public Date getDob() {
		return dob;
	}

	public String getMobile() {
		return mobile;
	}

	public String getCity() {
		return city;
	}

	public String getDobStr() {
		return dobStr;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDobStr(String dobStr) {
		this.dobStr = dobStr;
	}
	
	
	

}
