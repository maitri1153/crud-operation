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
import java.util.Arrays;

import com.ignek.crud.connection.DBConnection;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateform.jsp");
        dispatcher.forward(request, response);
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String fname = request.getParameter("fname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String date = request.getParameter("dob");
		String[] arr = request.getParameterValues("hobby");
		String hobby = Arrays.toString(arr); 
		PreparedStatement ptst;
		
		try {
			Connection con = DBConnection.initializeDatabase();
			ptst = con.prepareStatement("update Employee set name=?, email=?,gender=?, dob=?,hobby=? where emp_id=?");
			ptst.setString(1,fname);
			ptst.setString(2,email);
			ptst.setString(3,gender);
			ptst.setString(4,date);
			ptst.setString(5,hobby);
			ptst.setInt(6,emp_id);
			ptst.executeUpdate();	
			con.close();
			ptst.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
