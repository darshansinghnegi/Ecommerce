package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;

@WebFilter("*")
public class MyFilter implements Filter {

	private final String BASE_PATH="http://localhost:8094/hello/";
	
	String[] adminUrls = {
			BASE_PATH + "AddProduct.jsp",
			BASE_PATH + "AddCategory.jsp",
			BASE_PATH + "AddImageToBank.jsp"
	};
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse res = (HttpServletResponse)resp;
		
		User u = (User)req.getSession().getAttribute("currentUser");
		
		String role = null;
		
		if(u != null) {
			role = u.getRole();
		}
		
		int index = java.util.Arrays.asList(adminUrls).indexOf(req.getRequestURL().toString());
		System.out.println(index);
		
		if( index >= 0 && (role == null || !role.equals("admin")) ) {
			res.sendRedirect("Error.jsp");				
		}else {
			chain.doFilter(req, resp);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}		
	
}
