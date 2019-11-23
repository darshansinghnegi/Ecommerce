<%@page import="product.ProductHandler"%>
<%@page import="product.Product"%>
<%@page import="image.ImageBankHandler"%>
<%@page import="category.CategoryHandler"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="shared.jsp" />
<%
short id=Short.parseShort(request.getParameter("id"));
Product p=new ProductHandler().fetchProducts(id);
request.setAttribute("curCat", p);

CategoryHandler ch = new CategoryHandler();
request.setAttribute("productList", ch.fetchAllCategories());



ImageBankHandler ibh =new ImageBankHandler();
request.setAttribute("imaList", ibh.fetchAllImagesInBank());


%>
</head>

<style type="text/css">
.card{
    width: 33% !important;
    margin: 20% !important;
    display: inline-flex;
}

img{
   width: 100% !important;
   margin: 0;
}
.card-body{
    padding: 0;
    height: 33% !important;
}

.imageForDisplay{
    display: none;
    margin: auto;
    width: 80% !important;
    margin-top: 20px;

}
</style>



<body>
<c:import url="header.jsp"/>

<script type="text/javascript">
     var setImage = function (id,url) {
		alert(id+","+url);
		
		$("#imageSelectionModel").modal("hide");
		
		$("input[name='productImageId']").val(id)
		
		$(".imageForDisplay").attr('src',url);
		$(".imageForDisplay").show("fast");
    	 
	}
</script>

<!-- The Modal -->
<div class="modal fade" id="imageSelectionModel">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Choose Image</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       
       <c:choose>
          <c:when test="${empty imaList }">
            <h1 class="alert alert-danger">No Image In Bank</h1>
          </c:when>
       
         <c:otherwise>
             <br>
             
             <c:forEach items="${imaList}" var="image">
             <div class="card">
             <div class="card-body">
             <img  src="${image.getUrl()}">
             </div>
             <div class="card-footer">
             <a href="#" onclick="setImage(${image.getId()},'${image.getUrl()}')" class="btn btn-danger">Choose</a>
             </div>
             </div>
             </c:forEach>
         
         </c:otherwise>
       
       </c:choose>
       
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>



<br><br>
	

	<form action="EditImageFromDB" method="post">
	  <input type="hidden" name="ImageId">
		<div class="container">
						<br>
			
			<br>
			<div style="margin:auto; width: 100%; text-align: center;">
			
			<!-- Button to Open the Modal -->
           <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#imageSelectionModel">
           Select Image
           </button>
           <br>
           <img class="img imageForDisplay">
			</div>
			
			<br>
			
			<br>
			<br>
			
			
			
		  
			    <div class="row">
			       <div class="col-lg-12" style="text-align: center;">
			        <button class="btn btn-danger"><i class="fas fa-hand-point-right"></i>Edit</button>
			       </div>
			    </div>
			
		</div>
	</form>
</body>
</html>