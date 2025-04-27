package com.ignek.crud.servlet;

import java.io.IOException;
import com.ignek.crud.constant.EmployeeConstant;
import com.ignek.crud.dao.EmployeeDAO;
import com.ignek.crud.dto.Employee;
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
			int edit_id = Integer.parseInt(request.getParameter(EmployeeConstant.EDIT_ID));
			Employee employee = EmployeeDAO.getEmployee(edit_id);
			request.setAttribute(EmployeeConstant.EMPLOYEE, employee);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
