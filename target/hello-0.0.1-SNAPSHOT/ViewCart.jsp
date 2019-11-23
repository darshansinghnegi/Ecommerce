<%@page import="product.Product"%>
<%@page import="cart.Cart"%>
<%@page import="product.ProductHandler"%>
<%@page import="cart.CartHandler"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:import url="shared.jsp" />

<%
CartHandler uh = new CartHandler();
request.setAttribute("CList", uh.fetchAllProducts());

ProductHandler ph = new ProductHandler();

float grandTotal = 0.0f;
%>
  <!-- 
<style type="text/css">
.card {
   width: 86% !important;
   margin: 5px !important;
   display: inline-flex;
}
.card-body{
    padding: 0;
    margin: 0;
    height: 33% !important;
}

</style>
 -->  
 <body>
<c:import url="header.jsp" />

<br>
<br>

<h1 style="text-align: center;" class="alert alert-primary" >Cart</h1>
<br>
<a href="ViewProduct.jsp" class="btn-btn-Link">Add Product</a>

<c:choose>

<c:when test="${empty CList }">
<h1 class="alert alert-danger">Cart is empty please shop something from products</h1>
</c:when>

<c:otherwise>

<hr>
<c:forEach items="${CList}" var="cart">
<tr>
<td>
<!--  --> <%
  Cart x = (Cart) (pageContext.getAttribute("cart"));
  Product p = ph.fetchProducts((short) (x.getProductid()));
  //pageContext.setAttribute("pro",p);
 %> <%-- <%=p%> --%>
<div class="container">
    <div class="row">
        <div class="col-sm-4 py-2">
            <div class="card h-100">
                <div class="card-body">
                   <!--  <a href="#" class="btn btn-outline-light">Outline</a>
                   -->
                   <img style="width: 50%; margin: auto;"
src="<%=p.getImageUrl()%>">
<h2><%=p.getName()%></h2>

<c:if test="${sessionScope.currentUser.getRole() =='admin'}">
<h3 class="badge badge-pill badge-danger"><%=p.getCategory().getName()%></h3>
</c:if>
<h6 style="font-weight: bold;">
Price:<i id="R" class="fas-sign"></i><%=p.getPrice()%></h6>
<h6> Description : <span><%=p.getDescription()%></span></h6>

<c:if test="${sessionScope.currentUser.getRole() =='admin'}">
In Stock: <span class="badge badge-warning"
style="padding: 10px;">${pro.getStockqty()}</span>
</c:if>
 <%-- <h5> Quantity : <span>${cart.getQty()}</span></h5>
 --%>


 <form method="post" action="EditQty">
 
<input type="hidden" value="${sessionScope.currentUser.getId()}" name="userid">
<input type="hidden" name="id" value="${cart.getId()}">
<input type="hidden" value="${cart.getProductid()}" name="productid"> 
 
<span>Quantity :<input type="number" name="qty" placeholder="qty"
class="form-control" style="width: 30%;"  value="${cart.getQty()}" min="1" max="50"></span>
 <button class="btn btn-primary">update</button></span>

	 
	<%-- <a href="ViewCart.jsp?id=${sessionScope.currentUser.getId()}"
 class="btn btn-success" style="width: 80px; height: 30px;">Update</a>
 --%>
</form>

<h5>Sub-Total : <span><%=p.getPrice() * x.getQty()%></span></h5>
                   <a id="delete" href="DeleteCart?id=${cart.getId()}"
class="btn btn-danger" style="width: 300px; height: 35px;" >Delete</a>
                   
                   
                   
                   
                   
                   </div>
            </div>
        </div>
      </div>
</div>

<%
grandTotal += p.getPrice() * x.getQty();
%>

<%
session.setAttribute("grandTotal", grandTotal);
%>
<td>
<!-- <a href="" class="btn  btn-outline-primary">edit</a> --> 

</td>
</tr>
</c:forEach>



<h1 class="text text-success">
Grand Total:
<%=grandTotal%></h1>

<br>
<hr>
<%-- <a href="Destroy?id=${sessionScope.currentUser.getId()}"
 class="btn btn-success" style="width: 1350px; height: 50px;">
Confirm Order</a> --%>
<c:if test="${sessionScope.currentUser.getRole() =='user'}">

<a href="Address.jsp?id=${sessionScope.currentUser.getId()}"
 class="btn btn-success" style="width: 1350px; height: 50px;">
Confirm Order</a>
</c:if>
<br>
<br>
<br>

</c:otherwise>
</c:choose>

</body>
</html>


