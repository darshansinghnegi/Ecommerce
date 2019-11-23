package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.Product;
import product.ProductHandler;

@WebServlet(urlPatterns="/AddProductToDB")
public class AddProductToDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductHandler ph = new ProductHandler();
		Product p = new Product(
				req.getParameter("productName"),
				req.getParameter("productDescription"),
				Double.parseDouble(req.getParameter("productPrice")),
				Short.parseShort(req.getParameter("productStockqty")),
				Short.parseShort(req.getParameter("productCategoryId")),
				Integer.parseInt(req.getParameter("productImageId"))
				);
		ph.insert(p);
		resp.sendRedirect("ViewProduct.jsp");
		
		
	}

	
}
