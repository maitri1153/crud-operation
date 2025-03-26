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
import java.sql.SQLException;
import java.util.Arrays;

import com.ignek.crud.connection.DBConnection;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InsertServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registerform.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		 try
         {
 			Connection con = DBConnection.initializeDatabase();
 			PreparedStatement st = con.prepareStatement("insert into Employee values(?, ?, ?, ?, ?, ?)");
 			st.setInt(1, Integer.valueOf(request.getParameter("id")));
 			st.setString(2, request.getParameter("fname"));
 			st.setString(3, request.getParameter("email"));
 			st.setString(4, request.getParameter("gender"));
 			st.setString(5,request.getParameter("dob"));
 			String[] arr = request.getParameterValues("hobby");
 			String hobby = Arrays.toString(arr);
 			st.setString(6,hobby);
 			st.executeUpdate(); 
            st.close(); 
            con.close(); 
 		} 
         catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
	}

}
