package com.sprk.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import com.sprk.dao.EmployeeDao;
import com.sprk.model.Employee;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/employee")
public class ProcessFormController extends HttpServlet {

	private EmployeeDao employeeDao;

	@Resource(name = "emp_management")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String salaryStr = req.getParameter("salary");
		String joiningDateStr = req.getParameter("joiningDate");
		String email = req.getParameter("email");

		Date joiningDate = Date.valueOf(joiningDateStr);
        
		
		double salary = Double.parseDouble(salaryStr);

		Employee employee = new Employee(name, gender, salary, joiningDate, email);

		try {
			int result = employeeDao.addEmployee(employee);
			if (result > 0) {
				System.out.println("Insert Successfull");
			}else {
				System.out.println("Something Bad happen");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		session.setAttribute("Employee",employee);
//
//		resp.sendRedirect("dash.jsp");

	}
}