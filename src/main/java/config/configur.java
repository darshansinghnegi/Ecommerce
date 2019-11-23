package config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import category.Category;
import category.CategoryHandler;

@WebListener
public class configur implements ServletContextListener {
	public static final Connection conn = getConnection();
	
	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DB Connected");
		return	DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root", "root");
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("DB connected failure");
		}
		return null;
	}
	{
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
			try {
				conn.close();
				System.out.println("DB Disconnected");
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("DB Disconnection Failure");
			}
	
	}

	public void contextInitialized(ServletContextEvent sce) {
		
	//	Category c = new Category((short)1,"jkd","bjk");
		
//		CategoryHandler ch = new CategoryHandler();
//	System.out.println(ch.update(c));

			}

	
	
}
