<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:import url="shared.jsp" />
    <c:import url="header.jsp" />
    
<%@page import="order.Order"%>
<%@page import="order.OrderHandler"%>
<%@page import="cart.CartHandler"%>
<%@page import="product.ProductHandler"%>
<%@page import="user.UserHandler"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:import url="shared.jsp" />
<c:import url="header.jsp"></c:import>
<%

	OrderHandler oh = new OrderHandler();

	request.setAttribute("Order", oh.fetchAllOrders());
	
	
	
%>
</head>
<body>



</body>
</html>