package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeservelt")
public class employeeservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        	List<Employee> Empdetails = employeeDButil.display();
	        	request.setAttribute("Empdetails", Empdetails);
		
		RequestDispatcher dis = request.getRequestDispatcher("Employeedetails.jsp");
	       dis.forward(request, response);
	}
}
