<%@page import="user.UserHandler"%>
<%@page import="user.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cart.Cart"%>
<%@page import="java.util.List"%>
<html>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <head>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
html,body{
background-image: url('https://images.unsplash.com/photo-1527112862739-c3b9466d902e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1566&q=80');
background-size: cover;
background-repeat: no-repeat;
height: auto;
font-family: 'Numans', sans-serif;
}
</style>
  </head>
<body>
<%String Countrow="" ;%>
  <%
try
{
	User u1 = (User) request.getSession().getAttribute("currentUser");

	int id = u1.getId();
	User u = new UserHandler().fetchUsers(id);
	request.setAttribute("user", u);
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","root"); 
String strQuery = "SELECT COUNT(*) FROM cart where userid=?";
PreparedStatement p = con.prepareStatement(strQuery);

p.setInt(1, u.getId());

ResultSet rs = p.executeQuery();


while(rs.next()){
Countrow = rs.getString(1);
}
}
catch (Exception e){
e.printStackTrace();
}
%>
<div class="w3-container">

  <div class="w3-bar w3-light-grey ">
  <c:if test="${not empty sessionScope.currentUser}">
 		<a class="navbar-brand" href="#">Welcome ${sessionScope.currentUser.getEmail()}</a>
 		<a class=navbar-brand href="Logout">Logout</a>
 	</c:if>
 	 	<c:if test="${empty sessionScope.currentUser}">
    <a href="About.jsp" class="w3-bar-item w3-button">About</a>
    <a href="Contact.jsp" class="w3-bar-item w3-button">Contact</a>
   </c:if>
    	<c:if test="${sessionScope.currentUser.getRole() == 'user'}">
   
    <a href="About.jsp" class="w3-bar-item w3-button">About</a>
    <a href="Contact.jsp" class="w3-bar-item w3-button">Contact</a>
   </c:if>
    
<!--     <a href="Login.jsp" style="float:right;" class="w3-bar-item w3-button "><i class="fa fa-user"></i></a>
 -->    
 
 	<c:if test="${empty sessionScope.currentUser}">
    <a href="ViewCart.jsp" style="float:right;" class="w3-bar-item w3-button "><i class="fa fa-shopping-cart"><%=Countrow %></i></a>
 	</c:if>
 	<c:if test="${sessionScope.currentUser.getRole() == 'user'}">
    <a href="ViewCart.jsp" style="float:right;" class="w3-bar-item w3-button "><i class="fa fa-shopping-cart"><%=Countrow %></i></a>
 	</c:if>
 	<c:if test="${sessionScope.currentUser.getRole() == 'user'}">
    <a href="ViewProduct.jsp" style="float:right;" class="w3-bar-item w3-button "><i class="fa fa-home"></i></a>
 	</c:if>
 	
    <c:if test="${empty sessionScope.currentUser}">
    <div class="w3-dropdown-hover" style="float:right;">
      <button class="w3-button"><i class="fa fa-user"></i></button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="AddUser.jsp" class="w3-bar-item w3-button">signup</a>
        <a href="Login.jsp" class="w3-bar-item w3-button">login</a>
        
      </div>
    </div>
    </c:if>
    
    <c:if test="${sessionScope.currentUser.getRole() == 'admin'}">
    <div class="w3-dropdown-hover">
      <button class="w3-button">Category</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="AddCategory.jsp" class="w3-bar-item w3-button">Add Category</a>
        <a href="ViewCategory.jsp" class="w3-bar-item w3-button">View Category</a>
        
      </div>
    </div>
    </c:if>
    <c:if test="${sessionScope.currentUser.getRole() == 'admin'}">
    <div class="w3-dropdown-hover">
      <button class="w3-button">Product</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="AddProduct.jsp" class="w3-bar-item w3-button">Add Product</a>
        <a href="ViewProduct.jsp" class="w3-bar-item w3-button">View Product</a>
        
      </div>
    </div>
    </c:if>
    <c:if test="${sessionScope.currentUser.getRole() == 'admin'}">
    <div class="w3-dropdown-hover">
      <button class="w3-button">Image</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="AddImageToBank.jsp" class="w3-bar-item w3-button">Add Image</a>
        <a href="ViewImageBank.jsp" class="w3-bar-item w3-button">View Image</a>
        
      </div>
    </div>
    </c:if>
    <c:if test="${sessionScope.currentUser.getRole() == 'admin'}">
    <div class="w3-dropdown-hover">
      <button class="w3-button">User</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <!-- <a href="AddUser.jsp" class="w3-bar-item w3-button">Add User</a> -->
        <a href="ViewUser.jsp" class="w3-bar-item w3-button">View User</a>
        <a href="ViewOrder.jsp" class="w3-bar-item w3-button">View Order</a>
        
      </div>
    </div>
    </c:if>
    
    
    <%-- <c:if test="${sessionScope.currentUser.getRole() == 'admin'}">
    <div class="w3-dropdown-hover">
      <button class="w3-button">Login</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="Login.jsp" class="w3-bar-item w3-button">Login</a>        
      </div>
    </div>
    </c:if> --%>
  </div>
</div>

</nav>

</body>
</html>