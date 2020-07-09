/**
 * 
 */
package com.rts.service;

import com.rts.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee)throws Exception;
	
	public void updateEmployee(Employee employee)throws Exception;
	
	public void deleteEmployee(Long empId) throws Exception;
	
	public Object getemployeedetails(Long empId) throws Exception;
	
	
	
	
}
