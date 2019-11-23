package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.Cart;
import cart.CartHandler;
import product.Product;
import product.ProductHandler;
@WebServlet(urlPatterns="/AddToCart")
public class AddToCart extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		System.out.println("Add TO Cart");
		
		ProductHandler ph = new ProductHandler();
		Product pr = ph.fetchProducts(Short.parseShort(req.getParameter("productid")));
		int currStock = pr.getStockqty();
	   System.out.println(currStock);
	   
		int requestedStock = Integer.parseInt(req.getParameter("qty"));
		System.out.println(requestedStock);
		
		if(currStock < requestedStock)
		
		{
			resp.sendRedirect("NotEnoughStock.jsp");
		}else
		{
			CartHandler ch = new CartHandler();
			
			if(ch.checkProductInCart(Integer.parseInt(req.getParameter("productid")),
					Integer.parseInt(req.getParameter("userid"))))
			{
			resp.sendRedirect("AlreadyInCart.jsp");	
			}
			else {
				Cart c = new Cart(
						Integer.parseInt(req.getParameter("productid")),
						Integer.parseInt(req.getParameter("userid")),
						Integer.parseInt(req.getParameter("qty")));
				pr.setStockqty((short)(currStock - requestedStock));
				
				ph.update(pr);
				
				ch.insert(c);
				
				resp.sendRedirect("ViewProduct.jsp");
			}
		}
	}
    
}
