<%@page import="product.ProductHandler"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:import url="shared.jsp" />

<%
	ProductHandler ph = new ProductHandler();

	request.setAttribute("productList", ph.fetchAllProducts());
%>

</head>
<style type="text/css">
.card {
	width: 29% !important;
	margin: 5px !important;
	display: inline-flex;
	
}

.card-body {
	padding: 0;
	margin: 0;
	height: 13% !important;
}
</style>


<body style="border: ">

	<c:import url="header.jsp" />
	
	<br>
	<br>

	<h1 style="text-align: center;" class="alert alert-primary">Current
		product</h1>

	<br>
	<a href="AddProduct.jsp" class="btn btn-link">Add Product</a>

	<c:choose>

		<c:when test="${empty productList }">

			<h1 class="alert alert-danger">No Product Categories in DB</h1>

		</c:when>

		<c:otherwise>


			<hr>




			<c:forEach items="${productList}" var="product">

				<c:if test="${product.getStockqty() > 0}">


					<div class="card">

						<div class="card-body">

							<img style="width: 100%; margin: auto;"
								src="${product.getImageUrl()}">
							<h1>${product.getName()}</h1>
							<br>

							<h3 class="badge badge-success">${product.getCategory().getName()}</h3>
							<br>

							<h6>Price: Rs.${product.getPrice()}/-</h6>

							<br>

							<p>${product.getDescription()}</p>

							<h6>
								In Stock: <span class="badge badge-warning"
									style="padding: 10px;">${product.getStockqty()}</span>
							</h6>
						</div>

                          
						<div class="card-footer">
							<c:if test="${sessionScope.currentUser.getRole() == 'admin'}">

								<a href="EditProduct.jsp?id=${product.getId() }"
									class="btn btn-primary">Edit</a>
								<a href="DeleteProductFromDB?id=${product.getId() }"
									class="btn btn-danger">Delete</a>
							</c:if>
						
							<c:if test="${sessionScope.currentUser.getRole() == 'user'}">

								<div class="card-footer">
									<form action="AddToCart" method="post">
										<div class="container">
											<div class="row">
												<div class="col-lg-8">
													<button class="btn btn-info">Add Cart</button>
												</div>
												<br>
												<div class="col-lg-4">
													<input type="number" name="qty" placeholder="qty"
														class="form-control" style="width: 100%;">
												</div>
											</div>

										</div>

										<input type="hidden" value="${product.getId()}" name="productid" class="form-control">
										<input type="hidden" value="${sessionScope.currentUser.getId()}" name="userid">
									</form>
								</div>
							</c:if>
							
											</div>

										</div>



				</c:if>



			</c:forEach>



		</c:otherwise>

	</c:choose>


</body>
</html>