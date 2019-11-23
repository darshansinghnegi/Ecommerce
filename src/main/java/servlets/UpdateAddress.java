package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserHandler;



@WebServlet(urlPatterns="/UpdateAddress")
public class UpdateAddress extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String address = req.getParameter("address");
		
		User u = new User(id, address);
		
		UserHandler uh = new UserHandler();
		System.out.println(uh.update(u));
		
		
		resp.sendRedirect("Payment.jsp");
		
	}

	
	
}
