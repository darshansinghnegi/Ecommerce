<%@page import="product.ProductHandler"%>
<%@page import="product.Product"%>
<%@page import="user.User"%>
<%@page import="user.UserHandler"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@page import="cart.CartHandler"%>
<%@page import="cart.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:import url="shared.jsp" />

<%

int id=Integer.parseInt(request.getParameter("id"));
User u=new UserHandler().fetchUsers(id);
request.setAttribute("currCat", u);

CartHandler uh=new CartHandler();
request.setAttribute("CList", uh.fetchAllProducts());
ProductHandler ph=new ProductHandler();
%> 
</head>
<body>
<c:import url="header.jsp" />

<!------ Include the above in your HEAD tag ---------->

<%-- <%
  Cart x = (Cart) (pageContext.getAttribute("cart"));
  Product p = ph.fetchProducts((short) (x.getProductid()));
  //pageContext.setAttribute("pro",p);
 %> --%>
<div class="container">
	<div class="row">
		 <form action="UpdateAddress" method="post">
            <fieldset>
                <!-- Address form -->
         
                <h2>Address</h2>
                
                <input type="hidden" name="id" value="${currCat.getId()}">
         
                <!-- full-name input-->
                <div class="control-group">
                    <label class="control-label">Full Name</label>
                    <div class="controls">
                        <input id="full-name" name="full-name" type="text" style="width: 200px;" value="${currCat.getName()}" placeholder="full name"
                        class="input-xlarge" disabled>
                        <p class="help-block"></p>
                    </div>
                </div>
                <!-- address-line1 input-->
                <div class="control-group">
                    <label class="control-label">Address </label>
                    <div class="controls">
                        <input id="address-line1" name="address" type="text" value="${currCat.getAddress()}" style="width: 400px;"placeholder="address"
                        class="input-xlarge">
                        <%-- 
                       <%String grandTotal=session.getAttribute("grandTotal").toString(); %>
                <%=grandTotal %>
                    --%></div>
                </div>  
                <br>
                       
                                <button class="btn btn-primary" >Deliver to this Address</button>
                
                  <%-- <a href="Payment.jsp?id=${sessionScope.currentUser.getId()}"
 class="btn btn-success" style="width: 200px; height: 35px; ">
Deliver to this Address </a>  --%>
              
            </fieldset>
        </form>
	</div>
</div>
</body>
</html>