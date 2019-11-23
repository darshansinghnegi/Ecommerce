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
@WebServlet(urlPatterns="/EditQty")
public class EditQty extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CartHandler ch=new CartHandler();
		ProductHandler ph= new ProductHandler();
		
		
		Product p = ph.fetchProducts(Short.parseShort(req.getParameter("productid")));
		int currStock=p.getStockqty();

		Cart cart = ch.fetchProduct(Short.parseShort(req.getParameter("id")));
		int currCartStock=cart.getQty();
		
		int reqStock=Integer.parseInt(req.getParameter("qty"));
		if(currStock<reqStock) {
			resp.sendRedirect("NotEnoughStock.jsp");
		}
		else
		{
			Cart c=new Cart(
					Integer.parseInt(req.getParameter("id")),
					Integer.parseInt(req.getParameter("productid")),
					Integer.parseInt(req.getParameter("userid")),
					Integer.parseInt(req.getParameter("qty"))
					
					);
			p.setStockqty((short)(currStock+currCartStock-reqStock));
			ph.update(p);
			ch.update(c);
			
			resp.sendRedirect("ViewCart.jsp");
				
		}
		
/*
		
		int id = Integer.parseInt(req.getParameter("id"));
		int qty =Integer.parseInt(req.getParameter("qty"));
		
		Cart c = new Cart(id, qty);
		
		CartHandler ch = new CartHandler();
		System.out.println(ch.update(c));
		
		
		resp.sendRedirect("ViewCart.jsp");
*/		
		
	}

}
