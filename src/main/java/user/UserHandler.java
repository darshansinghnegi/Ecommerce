package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import category.Category;
import config.configur;
import product.Product;

interface UserStandard{
	String insert(User u);
	String update(User u);
	
	boolean deleteById(int id);
	String toggleActive(int id, boolean state);
	List<User>fetchAllUsers();
	

	User fetchUser(int id);
	
	
	User fetchUsers(int id);
	
	User checkLogin( String email, String password );}
public class UserHandler implements UserStandard {

	public String insert(User u) {

		try {
			
			String query = "insert into User"+"(name,phone,email,password)"+"values"+"(?,?,?,?)";
			
			Connection conn = configur.conn;
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, u.getName());
			p.setString(2, u.getPhone());
			p.setString(3, u.getEmail());
			p.setString(4, u.getPassword());
			
			
			
			p.executeUpdate();
			
		}catch(Exception e) {
			return e.getMessage();
		}
		
		return "Product Inserted Successfully";
	}

	public List<User> fetchAllUsers() {
		List<User> list = new ArrayList<User>();
		try {
			
			String query = "select * from user";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	           list.add(new User(
	        		   rs.getInt("id"),
	        		   rs.getString("name"),
	        		   rs.getString("phone"),
	        		   rs.getString("email"),
	        		   rs.getString("password"),
	        		  rs.getInt("active")
	        		   ));				
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
			return list;	}

	public User fetchUser(int id) {

		try {
					
					String query = "select * from user where id=?";
					Connection conn = configur.conn;
					PreparedStatement p = conn.prepareStatement(query);
		            
					p.setInt(1,id);
					
					ResultSet rs = p.executeQuery();
					
					while(rs.next()) {
						
					
					return new User(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("phone"),
							rs.getString("email")
							);			
					}
				}catch(Exception e) {
						e.printStackTrace();
					}
				
		
		
		return new User();
	}

	public boolean deleteById(int id) {
		
		try {
					
					String query = "delete from user where id=?";
					Connection conn = configur.conn;
					PreparedStatement p = conn.prepareStatement(query);
		            
					p.setInt(1,id);
					
					p.executeUpdate();
					
					return true;			
					
				}catch(Exception e) {
						e.printStackTrace();
					}
				
				return false;
			}

	public String toggleActive(int id, boolean state) {
		try {
			
			String query = "update  user set active =? where id=?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);
            
			p.setInt(1,state?1:0);
			p.setInt(2, id);
			
			p.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "success";
	}

public User checkLogin(String email, String password) {
		
		try {
			
			Connection conn = configur.conn;
			
			String query = "SELECT * FROM USER WHERE EMAIL =? AND PASSWORD = ? AND ACTIVE = 1";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, email);
			p.setString(2, password);
			
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				
				u.setEmail(rs.getString("EMAIL"));
				u.setRole(rs.getString("ROLE"));
				u.setId(rs.getInt("ID"));
				return u;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

public String update(User u) {
	try {
		
		String query = "update user set address=? where id=?";
		
		Connection conn = configur.conn;
		PreparedStatement p = conn.prepareStatement(query);
		
		p.setString(1, u.getAddress());
		p.setInt(2, u.getId());
		
		
		p.executeUpdate();
		
	}catch(Exception e) {
		return e.getMessage();
	}
	
	return "User Updated Successfully";}

public User fetchUsers(int id) {
	
	try {
		
		String query = "select * from user where id=?";
		Connection conn = configur.conn;
		PreparedStatement p = conn.prepareStatement(query);
        
		p.setInt(1,id);
		
		ResultSet rs = p.executeQuery();
		
		while(rs.next()) {
			
			User pr = new User();
			
			pr.setId(rs.getInt("id"));
			pr.setName(rs.getString("name"));
			pr.setAddress(rs.getString("Address"));
		
			return pr;
		}
	}catch(Exception e) {
			e.printStackTrace();
	}
	
	return null;
}

	}
