package com.sprk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.sprk.model.Employee;

public class EmployeeDao {
	
	private DataSource dataSource;

	public EmployeeDao(DataSource dataSource) {
//		System.out.println("Employee Dao Obj created");
		this.dataSource = dataSource;
	}

	public int addEmployee(Employee employee) throws Exception{
		// TODO Auto-generated method stub
			Connection conn = dataSource.getConnection();
			String sql = "insert into employee(name,gender,salary,joining_date,email) values (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getGender());
			ps.setDouble(3, employee.getSalary());
			ps.setDate(4, employee.getJoiningDate());
			ps.setString(5, employee.getEmail());

			return ps.executeUpdate();
		
		
	}
	
	
	
	
	

}
