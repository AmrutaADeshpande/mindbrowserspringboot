
package com.rts.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rts.bo.PaginationBo;
import com.rts.dao.EmployeeDao;
import com.rts.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private DataSource datasource;

	@Override
	public List<Employee> listEmployee(PaginationBo paginationBo) throws Exception {
		List<Employee> employee = new ArrayList<Employee>();
		String query;
		query = "SELECT * FROM employee e";
		Connection conn = null;
		try {
			conn = datasource.getConnection();
			
			if (paginationBo.getNumPerPage() > 0 && paginationBo.getPageNum() > 0) {
				query += " ORDER BY e.emp_id LIMIT  ?,? ";

			}
			PreparedStatement ps = conn.prepareStatement(query);
			int count = 0;
	
			if (paginationBo.getNumPerPage() > 0 && paginationBo.getPageNum() > 0) {
				ps.setLong(++count, (paginationBo.getPageNum() - 1) * paginationBo.getNumPerPage());
				ps.setLong(++count, paginationBo.getNumPerPage());
			}
			System.out.println("ps" + ps);
			ResultSet rs = ps.executeQuery();
			Employee emp = null;
			while (rs.next()) {
				emp= new Employee();
				emp.setEmpId(rs.getLong("emp_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));			
				employee.add(emp);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return employee;	
	}
}
