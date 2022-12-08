package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/deleteemployee")
public class deleteemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		
	
		boolean isTrue;
		
		isTrue = employeeDButil.deleteEmployee(empid);
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("employeeservelt");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccessfull.jsp");
			dis.forward(request, response);
		}
	}
}
