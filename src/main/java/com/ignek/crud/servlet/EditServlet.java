package com.ignek.crud.servlet;

import java.io.IOException;
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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter(EmployeeConstant.ID));
			Employee old_employee = EmployeeDAO.selectEmployee(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./registerform.jsp");
			request.setAttribute("employee", old_employee);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int Id = Integer.parseInt(request.getParameter(EmployeeConstant.ID));
			String name = request.getParameter(EmployeeConstant.FULL_NAME);
			String email = request.getParameter(EmployeeConstant.EMAIL);
			String gender = request.getParameter(EmployeeConstant.GENDER);
			String dob = request.getParameter(EmployeeConstant.DOB);
			String[] arr = request.getParameterValues(EmployeeConstant.HOBBY);
			String hobby = Arrays.toString(arr);
			Employee employee = new Employee(Id, name, email, gender, dob, hobby);
			EmployeeDAO.updateEmployee(employee);
			response.sendRedirect("InsertServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
