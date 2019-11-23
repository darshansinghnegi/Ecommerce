package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import product.Product;
import product.ProductHandler;


@WebServlet(urlPatterns="/EditProductFromDB")
public class EditProductFromDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
System.out.println("EditProductFromDB POST");

 int id = Integer.parseInt(req.getParameter("id")); 
String name = req.getParameter("productName");
String description = req.getParameter("productDescription");
 Double price = Double.parseDouble(req.getParameter("productPrice"));
  Short stockqty = Short.parseShort(req.getParameter("productStockqty"));
  Short categoryid = Short.parseShort(req.getParameter("productCategoryId"));
  Integer imageId = Integer.parseInt(req.getParameter("productImageId"));

Product p = new Product(id, name , description,price,stockqty,categoryid,imageId);

ProductHandler ph = new ProductHandler();
System.out.println(ph.update(p));


		
		resp.sendRedirect("ViewProduct.jsp");
	}

	  
	
}
