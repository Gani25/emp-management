package com.sprk.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import com.sprk.dao.EmployeeDao;
import com.sprk.model.Employee;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/employee/update")
public class UpdateController extends HttpServlet {

	private EmployeeDao employeeDao;

	@Resource(name = "emp_management")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String empId = req.getParameter("empId");

		if (!empId.isBlank() && empId.matches("\\d+")) {
		

//			Find That employee then show update form

			int eId = Integer.parseInt(empId);

			try {
				Employee employee = employeeDao.getEmployeeById(eId);
				
				if (employee.getEmpId() != 0) {
//				Show update form
					RequestDispatcher rd = req.getRequestDispatcher("/edit.jsp");
					req.setAttribute("employee", employee);
					rd.forward(req, resp);
				} else {
//					System.out.println("Inside else of nested");
					String msg = "Emp with Id " + eId + " not found!";
					session.setAttribute("errMsg", msg);
					resp.sendRedirect(req.getContextPath()+"/employee");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			session.setAttribute("errMsg", "Emp Id Doesnot Matches");

			resp.sendRedirect(req.getContextPath()+"/employee");
		}

	}

}