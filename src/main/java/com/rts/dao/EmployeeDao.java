
package com.rts.dao;

import java.util.List;
import com.rts.bo.PaginationBo;
import com.rts.model.Employee;


public interface EmployeeDao {
	
	public List<Employee> listEmployee(PaginationBo paginationBo) throws Exception;
}
