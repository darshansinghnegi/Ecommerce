
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:import url="shared.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<c:import url="header.jsp" />
<h1 style="text-align: center; color: green; font-style: italic; font-size: 100px;">HAPPY SHOPPING</h1>
    
   <a href="ViewProduct.jsp?id=${sessionScope.currentUser.getId() }"
 class="btn btn-success" style="width: 1350px; height: 50px;">
Continue Shopping</a>

</body>
</html>