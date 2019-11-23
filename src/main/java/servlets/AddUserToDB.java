package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.Category;
import category.CategoryHandler;
import user.User;
import user.UserHandler;
//@WebServlet(urlPatterns="/AddUserToDB")
public class AddUserToDB extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name = req.getParameter("uname"),
				phone = req.getParameter("uphone"),
						email = req.getParameter("uemail"),
								pass = req.getParameter("pswd");
								
		
		System.out.printf("NAME: %s , phone: %s ,email: %s,pass: %s",Name, phone,email,pass);
		
		User u = new User(Name, phone,email,pass);
		
		UserHandler uh = new UserHandler();
		uh.insert(u);
		
		System.out.println("User Added Succesfully");
		
		resp.sendRedirect("Login.jsp");
	}

	
}
