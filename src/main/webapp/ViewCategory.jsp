<%@page import="category.CategoryHandler"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="shared.jsp"/> 
<c:import url="header.jsp"></c:import>
<%
CategoryHandler ch = new CategoryHandler();
request.setAttribute("catList", ch.fetchAllCategories());

%>

</head>
<body>
  <br>
  <br>
  <h1 style="text-align: center;" class="alert alert-primary">Current Category</h1>
  
  <br>
  <a href="AddCategory.jsp" class="btn btn-link">Add Category</a>
  <c:choose>
  <c:when test="${empty catList }">
 
   <h1 class="alert alert-danger">No Categories in DB</h1> 
   
  </c:when>
 <c:otherwise>
 
  <hr>
  
  <table class="table table-striped">
  <thead>
     <tr>
        <th>#</th>
        <th>Name</th>
        <th>Description</th>
        <th>Operation</th>
     </tr>
  </thead>
  <tbody>
       
       <c:forEach items="${catList }" var="cat">
          <tr>
             <td>${cat.getId() }</td>
             <td>${cat.getName() }</td>
             <td>${cat.getDescription() }</td>
             <td>
                <a href="EditCategory.jsp?id=${cat.getId() }"
                 class="btn btn-primary">Edit</a>
                <a href="DeleteCategoryFromDB?id=${cat.getId() }" 
                class="btn btn-danger">Delete</a>
             </td>
          </tr>
       </c:forEach>
  </tbody>
  </table>
 
 </c:otherwise>
     
  </c:choose>
</body>
</html>