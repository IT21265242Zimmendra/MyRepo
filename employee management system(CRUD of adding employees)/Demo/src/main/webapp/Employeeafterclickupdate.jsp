<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Employeedetailsupdate.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
            String empid = request.getParameter("empid");
            String First_name = request.getParameter("Firstname");
            String Lastname = request.getParameter("Lastname");
            String address = request.getParameter("Address");
            String email = request.getParameter("Email");
            String department = request.getParameter("Department");
            
            System.out.println(empid);
            System.out.println(Lastname);
            
            
    %>
    
    
        <form action = "updateclick" method = "post">
         <div class="form">
    
            <div class="subtitle">Create Employee Account</div>
            <div class="input-container ic1">
              <input id="firstname" class="input" type="text" placeholder=" " name="Firstname" value = "<%out.println(First_name);%>"/>
              <div class="cut"></div>
              <label for="firstname" class="placeholder">First name</label>
            </div>
            <div class="input-container ic2">
              <input id="lastname" class="input" type="text" placeholder=" " name= "Lastname" value = "<%out.println(Lastname);%>"/>
              <div class="cut"></div>
              <label for="lastname" class="placeholder">Last name</label>
            </div>
            <div class="input-container ic3">
                <input id="email" class="input" type="text" placeholder=" " name = "empid" value = "<%out.println(empid);%>"/>
                <div class="cut"></div>
                <label for="email" class="placeholder">ID number</label>
              </div>
            <div class="input-container ic4">
              <input id="email" class="input" type="text" placeholder=" " name = "Email" value = "<%out.println(email);%>"/>
              <div class="cut"></div>
              <label for="email" class="placeholder">E - mail</label>
            </div>
            <div class="input-container ic5">
                <input id="email" class="input" type="text" placeholder="" name = "Address"  value = "<%out.println(address);%>" />
                <div class="cut"></div>
                <label for="email" class="placeholder">Address</label>
              </div>
              <div class="input-container ic7">
                <input id="email" class="input" type="text" placeholder=""  name = "Number"  />
                <div class="cut"></div>
                <label for="email" class="placeholder">Number</label>
              </div>
               <div class="input-container ic6">
                <input id="email" class="input" type="text" placeholder="" name = "Department"  value = "<%out.println(department);%>"/>
                <div class="cut"></div>
                <label for="email" class="placeholder">Department</label>
              </div>

            <button type="submit" class="submit" value = "add_employee">submit</button>
            
          
         </form>
       </body>
          
   
</body>
</html>