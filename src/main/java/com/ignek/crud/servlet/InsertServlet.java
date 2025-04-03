package com.ignek.crud.servlet;

import java.io.IOException;
import java.util.List;
import org.apache.catalina.tribes.util.Arrays;
import com.ignek.crud.constant.EmployeeConstant;
import com.ignek.crud.dao.EmployeeDAO;
import com.ignek.crud.dto.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employeelist = EmployeeDAO.getAllEmployees();
		request.setAttribute(EmployeeConstant.EMPLOYEE_LIST, employeelist);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		try {
			String id = request.getParameter(EmployeeConstant.ID);
			String name = request.getParameter(EmployeeConstant.FULL_NAME);
			String email = request.getParameter(EmployeeConstant.EMAIL);
			String gender = request.getParameter(EmployeeConstant.GENDER);
			String dob = request.getParameter(EmployeeConstant.DOB);
			String[] hobbylist = request.getParameterValues(EmployeeConstant.HOBBY);
			String hobby = Arrays.toString(hobbylist);
			if (id.isBlank()) {
				Employee employee = new Employee(name, email, gender, dob, hobby);
				EmployeeDAO.insertEmployee(employee);
			} else{
				int emp_id = Integer.parseInt(request.getParameter(EmployeeConstant.ID));
				Employee employee = new Employee(emp_id, name, email, gender, dob, hobby);
				EmployeeDAO.updateEmployee(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
}
