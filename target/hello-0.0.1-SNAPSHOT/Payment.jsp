<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="shared.jsp" />
<%@page import="order.Order"%>
<%@page import="order.OrderHandler"%>
<%@page import="cart.CartHandler"%>
<%@page import="product.ProductHandler"%>
<%@page import="product.Product"%>
<%@page import="user.UserHandler"%>
<%@page import="user.User"%>
<%@page import="product.ProductHandler"%>
<%@page import="product.Product"%>
<%@page import="user.User"%>
<%@page import="user.UserHandler"%>

<%@page import="cart.CartHandler"%>
<%@page import="cart.Cart"%>

<%
	/* CartHandler ch = new CartHandler();
	request.setAttribute("cart", ch.fetchAllProducts());
	
	ProductHandler ph = new ProductHandler();
	request.setAttribute("product", ph.fetchAllProducts());
	
	
	float grandTotal = 0.0f;
	 */

	User u1 = (User) request.getSession().getAttribute("currentUser");

	int id = u1.getId();
	User u = new UserHandler().fetchUsers(id);
	request.setAttribute("user", u);

	/* int i = Integer.parseInt(request.getParameter("id"));
	Product p = new ProductHandler().fetchProducts(i);
	request.setAttribute("product", p); */

	CartHandler uh = new CartHandler();
	request.setAttribute("CList", uh.fetchAllProducts());
	pageContext.getAttribute("cart");
	ProductHandler ph = new ProductHandler();
%>

</head>
<body>
	<c:import url="header.jsp" />
	<!------ Include the above in your HEAD tag ---------->
	<div class="container">
		<div class="row-fluid">
			<form class="form-horizontal" method="get" action="Destroy">
				<fieldset>


					<div id="legend">
						<legend class="">Payment</legend>
					</div>

					<!-- Name -->
					<div class="control-group">
						<label class="control-label" for="username">Card Holder's
							Name</label>
						<div class="controls">
							<input type="text" id="username" value="${user.getName()}"
								name="username" placeholder="" class="input-xlarge" required>
						</div>
					</div>

					<!-- Card Number -->
					<div class="control-group">
						<label class="control-label" for="email">Card Number</label>
						<div class="controls">
							<input type="tel" id="email" name="email" placeholder=""
								class="input-xlarge" maxlength="19" required>
						</div>
					</div>

					<!-- Expiry-->
					<div class="control-group">
						<label class="control-label" for="password">Card Expiry
							Date</label>
						<div class="controls">
							<select class="span3" name="expiry_month" id="expiry_month"
								required>
								<option></option>
								<option value="01">Jan (01)</option>
								<option value="02">Feb (02)</option>
								<option value="03">Mar (03)</option>
								<option value="04">Apr (04)</option>
								<option value="05">May (05)</option>
								<option value="06">June (06)</option>
								<option value="07">July (07)</option>
								<option value="08">Aug (08)</option>
								<option value="09">Sep (09)</option>
								<option value="10">Oct (10)</option>
								<option value="11">Nov (11)</option>
								<option value="12">Dec (12)</option>
							</select> <select class="span2" name="expiry_year" required>
								<option value="13">2013</option>
								<option value="14">2014</option>
								<option value="15">2015</option>
								<option value="16">2016</option>
								<option value="17">2017</option>
								<option value="18">2018</option>
								<option value="19">2019</option>
								<option value="20">2020</option>
								<option value="21">2021</option>
								<option value="22">2022</option>
								<option value="23">2023</option>
							</select>
						</div>
					</div>

					<!-- CVV -->
					<div class="control-group">
						<label class="control-label" for="password_confirm">Card
							CVV</label>
						<div class="controls">
							<input type="password" id="password_confirm"
								name="password_confirm" placeholder="" class="span2" required>
						</div>
					</div>
					<!-- 
          Save card
          <div class="control-group">
            <div class="controls">
              <label class="checkbox" for="save_card">
                <input type="checkbox" id="save_card" value="option1">
                Save card on file?
              </label>
            </div>
          </div> -->

					<!-- Submit -->
					<div class="control-group">
						<div class="controls"></div>
					</div>
					<%-- <c:forEach items="${CList}" var="cart">
						<%
							Cart x = (Cart) (pageContext.getAttribute("cart"));
								Product pr = ph.fetchProducts((short) (x.getProductid()));
								//pageContext.setAttribute("pro",p);
						%>
						<%
							String grandTotal = session.getAttribute("grandTotal").toString();
						%>
						<input type="text" name="name" value="${user.getName()}">
						<input type="text" name="proname" value="<%=pr.getName()%>">
						<input type="text" name="proqty" value="<%=x.getQty()%>">
						<input type="text" name="price" value="<%=pr.getPrice()%>">
						<input type="text" name="address" value="${user.getAddress()}">

					</c:forEach> --%>
					<input type="hidden" value="${sessionScope.currentUser.getId()}"
						name="id">

					<button class="btn btn-primary">Pay Now</button>

					<%--  <a href="Destroy?id=${sessionScope.currentUser.getId()}"
 class="btn btn-success" style="width: 150px; height: 30    px; margin-left: 150px;">
Pay Now</a>  --%>
				</fieldset>
			</form>



		</div>
	</div>
</body>
</html>