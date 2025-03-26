package com.ignek.crud.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ignek.crud.connection.DBConnection;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 response.setContentType("text/html");
		 int emp =Integer.parseInt(request.getParameter("id"));
		 
		 try {
			 Connection con = DBConnection.initializeDatabase();
			 PreparedStatement pts;
			 pts = con.prepareStatement("delete from Employee where emp_id =?");
			 pts.setInt(1,emp);
			 pts.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registerform.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
