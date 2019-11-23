package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import image.ImageBank;
import image.ImageBankHandler;
@WebServlet(urlPatterns="/EditImageFromDB")
public class EditImageFromDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	 int id = Integer.parseInt(req.getParameter("id")); 
	 String url = req.getParameter("url");
	 
		ImageBank ib =new ImageBank(id,url);
		 ImageBankHandler bh =new ImageBankHandler();
		 
		System.out.println(bh.update(ib));
		resp.sendRedirect("ViewImageBank.jsp");

	//	Integer imageId = Integer.parseInt(req.getParameter("ImageId"));
		
	
	
	
	}
}
	