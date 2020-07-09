
package com.rts.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rts.auth.dal.ObjectDao;
import com.rts.model.Employee;
import com.rts.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private ObjectDao objectDao;

	// Add employee details.
	
	@Override
	public void addEmployee(Employee employee) throws Exception {
		try
		{			
			if (employee.getDobStr() != null && !employee.getDobStr().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dob = sdf.parse(employee.getDobStr());
				employee.setDob(dob);
			}		
		     objectDao.saveObject(employee);
	}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	//update employee details

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		try
		{
			Employee emp=objectDao.getObjectById(Employee.class, employee.getEmpId());
			if (employee.getDobStr() != null && !employee.getDobStr().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dob = sdf.parse(employee.getDobStr());
				emp.setDob(dob);
			}
			emp.setAddress(employee.getAddress());
			emp.setCity(employee.getCity());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setMobile(employee.getMobile());
			objectDao.updateObject(emp);
		}
		catch(Exception e)
		{
			throw e;
		}
			
	}
	
	//delete employee records.

	@Override
	public void deleteEmployee(Long empId) throws Exception {
	try
	{
		Employee employee=objectDao.getObjectById(Employee.class, empId);
		objectDao.deleteObject(employee);
	}
	catch(Exception e)
	{
		throw e;
	}
		
	}
	
	//get employee details.

	@Override
	public Object getemployeedetails(Long empId) throws Exception {
		try
		{
			Employee emp=objectDao.getObjectById(Employee.class, empId);
			return emp;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
	}

}
