package com.ignek.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.catalina.tribes.util.Arrays;
import com.ignek.crud.constant.EmployeeConstant;
import com.ignek.crud.dao.EmployeeDAO;
import com.ignek.crud.dto.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employeelist = EmployeeDAO.selectAllEmployees();
		request.setAttribute("employeelist", employeelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registerform.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter(EmployeeConstant.FULL_NAME);
			String email = request.getParameter(EmployeeConstant.EMAIL);
			String gender = request.getParameter(EmployeeConstant.GENDER);
			String dob = request.getParameter(EmployeeConstant.DOB);
			String[] hobbylist = request.getParameterValues(EmployeeConstant.HOBBY);
			String hobby = Arrays.toString(hobbylist);
			Employee employee = new Employee(name, email, gender, dob, hobby);
			EmployeeDAO.insertEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
