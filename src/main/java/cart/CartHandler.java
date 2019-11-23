package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.configur;

interface CartStandard {
	String insert(Cart c);
    String update(Cart c);
	boolean deleteFromCart(int userid);

	boolean DeleteFromCart(int id);
	List<Cart> fetchAllProducts();

	List<Cart> fetchAllProducts(int id);
	
	boolean checkProductInCart(int userid, int productid);

	Cart fetchProduct(int id);

	void DeleteItemsFromCartForUser(int userId);
}

public class CartHandler implements CartStandard {

	public void DeleteItemsFromCartForUser(int userId) {
		
		try {

			String query = "delete from cart where userId=?";

			Connection conn = configur.conn;

			PreparedStatement p = conn.prepareStatement(query);
			p.setInt(1, userId);
			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String insert(Cart c) {
		try {

			String query = "insert into cart" + "(productid,userid,qty)" + "values" + "(?,?,?)";

			Connection conn = configur.conn;

			PreparedStatement p = conn.prepareStatement(query);
			p.setInt(1, c.getProductid());
			p.setInt(2, c.getUserid());
			p.setInt(3, c.getQty());

			p.executeUpdate();

		} catch (Exception e) {
			return e.getMessage();
		}
		return "Cart Insert Successfully";
	}

	public boolean deleteFromCart(int userid) {
		try {

			String query = "delete from cart where userid=?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, userid);
			p.executeUpdate();

			return true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}

	public boolean checkProductInCart(int productid, int userid) {

		try {
			String query = "select * from cart where productid=? and userid=?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, productid);
			p.setInt(2, userid);

			ResultSet rs = p.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Cart> fetchAllProducts() {

		List<Cart> list = new ArrayList<Cart>();
		try {
			String query = "select * from cart";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				list.add(new Cart(rs.getInt("id"), rs.getInt("productId"), rs.getInt("userId"), rs.getInt("qty")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Cart> fetchAllProducts(int id) {

		List<Cart> list = new ArrayList<Cart>();
		try {
			String query = "select * from cart where userid=?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, id);
			
			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				list.add(new Cart(rs.getInt("id"), rs.getInt("productId"), rs.getInt("userId"), rs.getInt("qty")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Cart fetchProduct(int id) {

		try {

			String query = "select * from cart where id= ?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, id);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {
				return new Cart(rs.getInt("id"), rs.getInt("productId"), rs.getInt("userId"), rs.getInt("qty"));
                
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Cart();
	}

	public String update(Cart c) {
		try {
			
			String query = "update cart set qty=? where id=?";
			
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setInt(1, c.getQty());
			p.setInt(2, c.getId());
			
			
			p.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		return "Cart Updated Successfully";
	}

	@Override
	public boolean DeleteFromCart(int id) {
		try {

			String query = "delete from cart where id=?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, id);
			p.executeUpdate();

			return true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}
}
