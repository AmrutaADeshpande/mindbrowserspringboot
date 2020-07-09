
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
@Table(name="manager")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manager_Id",nullable = false)
	private Long managerId;
	
	@Column(name = "first_name")
	private String firtName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "email", unique = true, length=255)
	private String email;
	
	@Column(name = "dob", nullable=true)
	private Date dob;
	
	@Column(name="company")
	private String company;
	
	@Transient
	private String dobstr;


	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
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

	public Date getDob() {
		return dob;
	}

	public String getCompany() {
		return company;
	}

	public String getDobstr() {
		return dobstr;
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

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDobstr(String dobstr) {
		this.dobstr = dobstr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
