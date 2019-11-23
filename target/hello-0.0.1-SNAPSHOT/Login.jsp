<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="shared.jsp" />

</head>
<style>
body{
}
form-group{
   margin: auto;
   padding: auto;
   
}

</style>
<body>
<c:import url="header.jsp"/>

	<h1 style="margin-left: 530px;">Login</h1>
	
	<c:if test="${not empty invalid}">
		<h1 class="alert alert-danger">Invalid Credentials</h1>
	</c:if>

<form action="CheckLogin" method="post">
	
     <div class="form-group">
    <input type="email" class="form-control" id="email" name="uemail" placeholder="Email Address">
  </div>
    <div class="form-group">
      <input type="password" class="form-control" id="pwd" name="pswd"  placeholder="Enter password">
     
    </div>
  
   
    <button type="submit" class="btn btn-primary" style="margin-left: 550px;">Login</button>
  </form>





</body>
</html>