<%@page import ="user.UserHandler" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:import url="shared.jsp" />
<c:import url="header.jsp"></c:import>
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<%

	UserHandler uh = new UserHandler();

	request.setAttribute("UserList", uh.fetchAllUsers());
%>
</head>
<body>
<br>
  <br>
  <h1 style="text-align: center;" class="alert alert-primary">Current Users</h1>
  
  <br>
  <c:choose>
  <c:when test="${empty UserList }">
 
   <h1 class="alert alert-danger">No Users in DB</h1> 
   
  </c:when>
 <c:otherwise>
 
  <hr>
  
  <table class="table table-striped">
  <thead>
     <tr>
        <th>#</th>
        <th>Name</th>
        <th>Phone</th>
        <th>email</th>
     </tr>
  </thead>
  <tbody>
       
       <c:forEach items="${UserList }" var="usr">
          <tr>
             <td>${usr.getId() }</td>
             <td>${usr.getName() }</td>
             <td>${usr.getPhone() }</td>
             <td>${usr.getEmail() }</td>
             <td>
            <!--     <a href="EditUser.jsp?id=${usr.getId() }" 
                class="btn btn-success">Edit</a> -->
                <a href="DeleteUserFromDB?id=${usr.getId() }" 
                class="btn btn-danger">Delete</a>
             <c:if test="${usr.getActive()==1}">
               <a href="SetUserInActive?id=${usr.getId()}" class="btn btn-link">Set Inactive</a>
               </c:if>
               <c:if test="${usr.getActive()==0 }">
               <a href="SetUserToActive?id=${usr.getId()}" class="btn btn-link">
               set Active</a>
               </c:if>
             </td>
          </tr>
       </c:forEach>
  </tbody>
  </table>
 
 </c:otherwise>
     
  </c:choose>
</body>
</html>