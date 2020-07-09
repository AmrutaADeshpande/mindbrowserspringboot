
package com.rts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rts.bo.PaginationBo;
import com.rts.bo.Response;
import com.rts.dao.EmployeeDao;
import com.rts.model.Employee;
import com.rts.service.EmployeeService;


@RestController
@RequestMapping(value = "/v1/employee")
public class EmployeeController {
	
	private static final Logger log = LogManager.getLogger(EmployeeController.class);
    
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeDao employeeDao;


	@CrossOrigin
	@PostMapping(value = "/addemployee")
	public Response addEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		try {
			employeeService.addEmployee(employee);
			response.setStatus("200");
			response.setMessage("Employee added successfully");
			response.setResult(employee);
			return response;
		} catch (Exception e) {
			log.error("ERROR IN addEmployee(): ", e);
			response.setStatus("500");
			response.setMessage("Internal server error");
			return response;
		}
	}
	

	@CrossOrigin
	@GetMapping("/details/{empId}")
	public Response employeeDetails(@PathVariable("empId") Long empId) {
		Response response = new Response();
		try {
			
			response.setStatus("200");
			response.setMessage("Employee details");
			response.setResult(employeeService.getemployeedetails(empId));
			return response;
		} catch (Exception e) {
			log.error("Error In : ", e);
			response.setStatus("500");
			response.setMessage("Internal server error");
			return response;
		}
	}

	@CrossOrigin
	@PutMapping("/editemployee")
	public Response editEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		try {
			employeeService.updateEmployee(employee);
			response.setStatus("200");
			response.setMessage("Employee updated successfully");
			return response;
		} catch (Exception e) {
			log.error("ERROR IN editEmployee(): ", e);
			response.setStatus("500");
			response.setMessage("Internal Server Error");
			return response;
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/{empId}")
	public Response deleteEmployee(@PathVariable("empId") Long empId) throws Exception {
		Response response = new Response();
		try {
			employeeService.deleteEmployee(empId);
			response.setMessage("Employee deleted Successfully");
			response.setStatus("200");
			return response;

		} catch (Exception e) {
			log.error("ERROR IN deleteEmployee(): ", e);
			response.setStatus("500");
			response.setMessage("Internal Server Error");
			return response;
		}

	}

	@CrossOrigin
	@PostMapping("/list")
	public Response listEmployee(@RequestBody PaginationBo paginationBo) {
		Response response = new Response();
		try {
			response.setStatus("200");
			response.setMessage("listEmployee");
			response.setResult(employeeDao.listEmployee(paginationBo));
			return response;
		} catch (Exception e) {
			log.error("ERROR IN listEmployee() : ", e);
			response.setStatus("500");
			response.setMessage("Internal Server Error");
			response.setResult(e.getMessage());
			return response;
		}
	}
	
	
	

	
	
	

}
