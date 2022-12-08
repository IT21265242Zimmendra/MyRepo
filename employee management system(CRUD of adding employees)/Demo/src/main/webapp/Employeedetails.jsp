<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
    <html lang="en">
      <head>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Employeedetails.css">
      
        <title></title>
      </head>
     
        

          
      <ul>
          <li><a href="#Home">Home</a></li>
          <li><a href="#Salary">Salary</a></li>
          <li><a href="#Department">Department</a></li>
          <li><a href="#Employee">Employee</a></li>
         
          <li><a href="Logout">Logout</a></li>

          <li class="logo"><img src = "C:\EmployeeManagementSystem\main page\img\zurita.jpg" class="item1"></li>
        
        </ul>
   <body>
        <table class="styled-table">
            <thead>
                <tr>
                    <th>Employee id</th>
                    <th>Employee Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            
            <tbody>
               <c:forEach var="emp" items="${Empdetails}">
            <%--    <c:set var = "empid" value = "${emp.getEmployee_id()}"/>
               <c:set var = "Firstname" value = "${emp.getFirst_name()}"/>
               <c:set var = "Lastname" value = "${emp.getLast_name()}"/>
               <c:set var = "Email" value = "${emp.getEmail() }"/>
               <c:set var = "Address" value = "${emp.getAddress()}"/>
               <c:set var = "Department" value = "${emp.getDepartment()}"/> --%>
         <tr>
                    <td>${emp.getEmployee_id()}</td>
                    <td>${emp.getFirst_name()} ${emp.getLast_name()} </td>
                    <td>${emp.getAddress()} </td>
                    <td>${emp.getEmail()}</td>               
                    <td>${emp.getDepartment()}</td>
                   
                <td>
                    <form action = "Employeeafterclickupdate.jsp" method = "post">
                    <input type="submit" name ="update" value = "Update">
                    <input type = "hidden" name = "empid" value = "${emp.getEmployee_id()}">
                    <input type = "hidden" name = "Firstname" value = "${emp.getFirst_name()}">
                    <input type = "hidden" name = "Lastname" value = "${emp.getLast_name()}">
                    <input type = "hidden" name = "Address" value = "${emp.getAddress()}">
                    <input type = "hidden" name = "Email" value = "${emp.getEmail()}">             
                    <input type = "hidden" name = "Department" value = "${emp.getDepartment()}">
                    </form>
               </td>
                  <td>  <form action= "deleteclick" method = "post"><input type = "submit" name = "delete" value = "Delete">
                  			<input type = "hidden" name = "empid" value = "${emp.getEmployee_id()}">
                  
                  		</form>
                  	</td>
                    
	
	
                </tr>  
            </c:forEach>	
	


               
            </tbody>
       </table>
       <form action = "insert" method = "post">
        <div class="form">
    
            <div class="subtitle">Create Employee Account</div>
            <div class="input-container ic1">
              <input id="firstname" class="input" type="text" placeholder=" " name="Firstname"/>
              <div class="cut"></div>
              <label for="firstname" class="placeholder">First name</label>
            </div>
            <div class="input-container ic2">
              <input id="lastname" class="input" type="text" placeholder=" " name= "Last_name" />
              <div class="cut"></div>
              <label for="lastname" class="placeholder">Last name</label>
            </div>
            <div class="input-container ic3">
                <input id="email" class="input" type="text" placeholder=" " name = "empid"/>
                <div class="cut"></div>
                <label for="email" class="placeholder">ID number</label>
              </div>
            <div class="input-container ic4">
              <input id="email" class="input" type="text" placeholder=" " name = "Email"/>
              <div class="cut"></div>
              <label for="email" class="placeholder">E - mail</label>
            </div>
            <div class="input-container ic5">
                <input id="email" class="input" type="text" placeholder="" name = "Address" />
                <div class="cut"></div>
                <label for="email" class="placeholder">Address</label>
              </div>
              <div class="input-container ic7">
                <input id="email" class="input" type="text" placeholder=""  name = "Number"/>
                <div class="cut"></div>
                <label for="email" class="placeholder">Number</label>
              </div>
               <div class="input-container ic6">
                <input id="email" class="input" type="text" placeholder="" name = "Department"/>
                <div class="cut"></div>
                <label for="email" class="placeholder">Department</label>
              </div>

            <button type="submit" class="submit" value = "add_employee">submit</button>
            
          </div>
         </form>
       </body>

     
      
  </html>
