package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// reading functionality 
public class employeeDButil {
	static String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
    static String user ="root";
    static String password1 = "Zimmendra@03";
	public static List<Employee> display(){
		
		 ArrayList<Employee> Emp = new ArrayList<>();
	   //create database connection 
		
	
	    //validate
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    
	    	Connection con = DriverManager.getConnection(url,user,password1);
	        Statement stmt = con.createStatement();
	        
	        String Sql = "select * from emp_details";
	        
	        ResultSet rs = stmt.executeQuery(Sql);
	        
	        while(rs.next()) {
	        	String Employee_id = rs.getString("emp_ID");
	        	String First_name = rs.getString("first_name");
	        	String Last_name = rs.getString("last_name");
	        	String Email = rs.getString("email");
	        	String Address = rs.getString("address");
	        	String Department = rs.getString("d_name");
	        	
	        	
	        	Employee e = new Employee(Employee_id,First_name,Last_name,Email,Address,Department);
	        	Emp.add(e);
	        	
	        }
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    return Emp;
	}


	public static boolean updateemployee(String empid, String first_name, String last_name,String address, String number , String email,String Department) {
		boolean isSuccess = false;
		try {
               Class.forName("com.mysql.jdbc.Driver");
		    
   	    	Connection con = DriverManager.getConnection(url,user,password1);
	        Statement stmt = con.createStatement();
		    String sql = " update employeemanagementsystem.emp_details "
		    		+ " set first_Name = '"+first_name+"', last_Name = '"+last_name+"', Address =  '"+address+"',  phone = '"+number+"', email = '"+email+"',d_name = '"+Department+"' "
		    		+ " where emp_ID = '"+empid+"' ";
		    
		    	int rs = stmt.executeUpdate(sql);
		    	if(rs>0) {
		    		isSuccess = true;
		    	}
		    	else {
		    		isSuccess = false;
		    	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
//Delete functionality 
	public static boolean deleteEmployee(String empid ) {
	boolean isSuccess = false;
	try {
        Class.forName("com.mysql.jdbc.Driver");
	    
	    	Connection con = DriverManager.getConnection(url,user,password1);
     Statement stmt = con.createStatement();
	    String sql = " delete from employeemanagementsystem.emp_details  where emp_ID = '"+empid+"' ";
	    	int rs = stmt.executeUpdate(sql);
	    	if(rs>0) {
	    		isSuccess = true;
	    	}
	    	else {
	    		isSuccess = false;
	    	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
	
}
	public static boolean insertemployee(String empid, String first_Name, String last_Name, String address,
			String phone,String email , String department ) {
	boolean isSuccess = false;
		
		
		//database connection
		
		String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
	    String user ="root";
	    String password1 = "Zimmendra@03";
	    String dept_Id = "";
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
		    
	    	Connection con = DriverManager.getConnection(url,user,password1);
	        Statement stmt = con.createStatement();
	        
	        String retrieveSql = "select dept_ID FROM department where dept_Name = '"+department+"'";
	        ResultSet r = stmt.executeQuery(retrieveSql);
	        
	        if ( r.next())
	        {
	        	dept_Id = r.getString(1);
	        }
	        
	        
	        String Sql = "Insert into emp_details values('"+empid+"','"+first_Name+"','"+last_Name+"','"+address+"','" +phone+ "' ,'" +email+ "' ,'"+dept_Id+"','"+department+"') ";
	        int rs = stmt.executeUpdate(Sql);
	        if(rs>0) {
	        	isSuccess = true;
	        }else {
	        	isSuccess = false;
	        }
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	
	}


	
}
