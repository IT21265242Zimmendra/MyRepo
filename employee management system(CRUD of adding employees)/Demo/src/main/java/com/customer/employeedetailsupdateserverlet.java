package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/employeedetailsupdateserverlet")
public class employeedetailsupdateserverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Department;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		String first_name = request.getParameter("Firstname");
		String Last_name = request.getParameter("Lastname");
		String Address = request.getParameter("Address");
		String Number = request.getParameter("Number");
		String Email = request.getParameter("Email");
		String Department = request.getParameter("Department");

		System.out.println(empid);
	
		boolean isTrue;
		
		isTrue = employeeDButil.updateemployee(empid, first_name, Last_name, Address, Number, Email,Department);
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("employeeservelt");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccessfull.jsp");
			dis.forward(request, response);
		}
	}

}
