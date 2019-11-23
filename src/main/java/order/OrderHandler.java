package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cart.Cart;
import cart.CartHandler;
import category.Category;
import config.configur;
import order.Order;
import product.Product;

interface OrderStandard {
	String insert(Order o);

	String update(Order o);

	boolean deleteById(int id);

	Order fetchOrders(int id);

	List<Order> fetchAllOrders();
	
	void updateCartToOrders(int userId);
}

public class OrderHandler implements OrderStandard {

	
	
	@Override
	public void updateCartToOrders(int userid) {
		// TODO Auto-generated method stub
		
		System.out.println("insert");
		String query = "select x.name,p.name as proname,x.qty as proqty,price*qty as price,x.address "
				+ "from "
				+ "(select name,address,qty,userid,productid "
				+ "from user u INNER JOIN cart c on u.id = c.userid "
				+ "where c.userid=?) x INNER JOIN product p on p.id=x.productid;";
	
		try {

			Connection conn = configur.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, userid);
			
			ResultSet rs = p.executeQuery();

			
			
			while(rs.next()) {
				Order o = new Order();
				o.setName(rs.getString("name"));
				o.setProname(rs.getString("proname"));
				o.setProQty(rs.getInt("proqty"));
				o.setPrice(rs.getFloat("price"));
				o.setAddress(rs.getString("address"));
			
				
				this.insert(o);
				System.out.println(o);
			}
			
			CartHandler ch = new CartHandler();
			
			ch.deleteFromCart(userid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public String insert(Order o) {

		try {

			String query = "insert into ordsum" + "(name,proname,proqty,price,address)" + "values" + "(?,?,?,?,?)";

			Connection conn = configur.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, o.getName());
			p.setString(2, o.getProname());
			p.setInt(3, o.getProQty());
			p.setFloat(4, o.getPrice());
			p.setString(5, o.getAddress());

			p.executeUpdate();

		} catch (Exception e) {
			return e.getMessage();
		}

		return "Insert Success fully";
	}

	@Override
	public String update(Order o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order fetchOrders(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> fetchAllOrders() {

		List<Order> list = new ArrayList<Order>();
		try {

			String query = "select * from ordsum";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {
				list.add(new Order(rs.getInt("Id"),
						rs.getString("Name"),
						rs.getString("Proname"),
						rs.getInt("ProQty"),
						rs.getFloat("Price"),
						rs.getString("Address")

				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
