<%@page import="image.ImageBankHandler"%>
<%@page import="product.ProductHandler"%>
<%@page import="order.OrderHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
OrderHandler oh = new OrderHandler();
request.setAttribute("OrderList", oh.fetchAllOrders());

ProductHandler ph = new ProductHandler();

ImageBankHandler ih= new ImageBankHandler();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<c:choose>
  <c:when test="${empty OrderList }">
 
   <h1 class="alert alert-danger">No Users in DB</h1> 
   
  </c:when>
 <c:otherwise>
 
  <hr>
  
  <table class="table table-striped">
  <thead>
     <tr>
        <th>#</th>
        <th>Name</th>
        <th>ProName</th>
        <th>ProQty</th>
        <th>Price</th>
        <th>Address</th>
     </tr>
  </thead>
  <tbody>
       
       <c:forEach items="${OrderList }" var="ord">
          <tr>
             <td>${ord.getId() }</td>
             <td>${ord.getName() }</td>
             <td>${ord.getProname()}</td>
             <td>${ord.getProQty() }</td>
             <td>${ord.getPrice() }</td>
             <td>${ord.getAddress() }</td>
             
             <td>
          
              
             </td>
          </tr>
       </c:forEach>
  </tbody>
  </table>
 
 </c:otherwise>
     
  </c:choose>


</body>
</html>