package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeInsert")
public class EmployeeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String empid = request.getParameter ("empid");
		String First_name = request.getParameter("Firstname");
	    String Last_name = request.getParameter("Last_name");
	    String Address = request.getParameter("Address");
	    String Number = request.getParameter("Number");
	    String Email = request.getParameter("Email");
	    String Department = request.getParameter("Department");
	
	    boolean isTRUE;
	    isTRUE = employeeDButil.insertemployee(empid, First_name, Last_name, Address, Number, Email, Department);
	   if(isTRUE == true) {
	   RequestDispatcher dis = request.getRequestDispatcher("employeeservelt");
		   dis.forward(request, response);	
		   }
	
	else {
		
		RequestDispatcher dis2 = request.getRequestDispatcher("unsuccessfull.jsp");
		dis2.forward(request, response);
	}
	}
}
