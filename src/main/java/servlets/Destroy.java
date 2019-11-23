package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.Cart;
import cart.CartHandler;
import order.Order;
import order.OrderHandler;
import product.Product;
import product.ProductHandler;

@WebServlet(urlPatterns = "/Destroy")
public class Destroy extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userid = Integer.parseInt(req.getParameter("id"));
		System.out.println(userid);
		OrderHandler oh = new OrderHandler();
		oh.updateCartToOrders(userid);
		System.out.println("last");

		resp.sendRedirect("thank.jsp");
		/*System.out.println("Add summry");
		String name = req.getParameter("name");
				System.out.println("name");
			String proname = req.getParameter("proname");
			System.out.println("pr"); 
			
			int proQty = Integer.parseInt(req.getParameter("proqty"));
			System.out.println("prq");
			float price = Float.parseFloat(req.getParameter("price"));
			System.out.println("pri");
			String address = req.getParameter("address");
			System.out.println("adi");
			System.out.printf("name: %s , proname: %s ,address: %s",name, proname,address);
		
		Order o = new Order(name, proname, proQty , price ,  address);
		
		OrderHandler oh = new OrderHandler();
		oh.insert(o);
		
		
		if( req.getParameter("id") == null ) {
			resp.sendRedirect("Login.jsp");
		}else {
			int id = Integer.parseInt(req.getParameter("id"));

			CartHandler ch = new CartHandler();
			ch.DeleteItemsFromCartForUser(id);
			
			resp.sendRedirect("thank.jsp");
	}
		*/
	}

}
