package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.Category;
import category.CategoryHandler;

public class AddCategoryToDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Add CategoryToDB Post");
		String catName = req.getParameter("categoryName"),
				catDesc = req.getParameter("categoryDescription");
		
		System.out.printf("NAME: %s , DESC: %s\n",catName, catDesc);
		
		Category c = new Category(catName, catDesc);
		
		CategoryHandler ch = new CategoryHandler();
		ch.insert(c);
		
		System.out.println("Category Added Succesfully");
		
		resp.sendRedirect("ViewCategory.jsp");
	
	}

	
}
