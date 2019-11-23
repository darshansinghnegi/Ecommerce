<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:import url="shared.jsp" />
</head>
<body>

<c:import url="header.jsp" />

<h1 style="text-align: center;" class="alert alert-primary">Add Image</h1>

<form method="post" action="UploadFile" enctype="multipart/form-data">
   <input type="file" name="myfile" class="form-control">
   
   <br>
   <br>
   
   <input type="submit" value="Go" class="btn btn-success">

</form>
</body>
</html>