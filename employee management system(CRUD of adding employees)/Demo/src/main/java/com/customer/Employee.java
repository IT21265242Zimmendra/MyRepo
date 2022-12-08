package com.customer;

public class Employee {
       private String Employee_id;
       private String First_name;
       private String Last_name;
       private String Email;
       private String Address;
       private String Department;
	
	public Employee(String employee_id, String first_name, String last_name, String email, String address,
			String department) {
		Employee_id = employee_id;
		First_name = first_name;
		Last_name = last_name;
		Email = email;
		Address = address;
		Department = department;
	}

	public String getEmployee_id() {
		return Employee_id;
	}

	public String getFirst_name() {
		return First_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public String getEmail() {
		return Email;
	}

	public String getAddress() {
		return Address;
	}

	public String getDepartment() {
		return Department;
	}
	
       
}
