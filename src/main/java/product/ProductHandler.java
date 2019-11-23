package product;


import java.util.List;

import category.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.configur;



interface ProductStandard{
		String insert(Product p);
		String update(Product pr);
		
		boolean deleteById(int id);
		
		Product fetchProducts(int id);
		
List<Product>fetchAllProducts();		
}

public class ProductHandler implements ProductStandard {

	public String insert(Product pr) {

		try {
			
			String query = "insert into Product"+"(name,description,price,stockqty,categoryid,imageId)"+"values"+"(?,?,?,?,?,?)";
			
			Connection conn = configur.conn;
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, pr.getName());
			p.setString(2, pr.getDescription());
			p.setDouble(3, pr.getPrice());
			p.setShort(4, pr.getStockqty());
			p.setShort(5, pr.getCategoryid());
			p.setInt(6, pr.getImageId());
			
			p.executeUpdate();
			
		}catch(Exception e) {
			return e.getMessage();
		}
		
		return "Product Inserted Successfully";
	}
	
	public String update(Product pr) {
		try {
			
			String query = "update Product set name=?,description=?,price=?,stockqty=?,categoryid=?,imageId=? where id=?";
			
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, pr.getName());
			p.setString(2, pr.getDescription());
            p.setDouble(3, pr.getPrice());
			 p.setShort(4, pr.getStockqty());
		     p.setShort(5, pr.getCategoryid());
		     p.setInt(6, pr.getImageId());
		     p.setInt(7, pr.getId());


			
			p.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		return "Product Updated Successfully";
	}

	public List<Product>fetchAllProducts(){
		List<Product> list = new ArrayList<Product>();
		try {
			
			String query = "select p.*,c.name as catName,c.description as catDesc, ib.url as imageUrl from product p,category c,imagebank ib where c.id = p.categoryid and ib.id=p.imageId";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);

			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
               list.add(new Product(
            		   rs.getInt("id"),
            		   rs.getString("name"),
            		   rs.getString("description"),
            		   rs.getDouble("price"),
            		   rs.getShort("stockqty"),
            		   rs.getShort("categoryid"),
            		   rs.getString("imageUrl"),
            		   new Category(rs.getString("catName"),rs.getString("catDesc"))
            		   
            		   ));				
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}

	public boolean deleteById(int id) {
		
try {
			
			String query = "delete from Product where id=?";
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

	public Product fetchProducts(int id) {

		
		try {
					
					String query = "select p.*,c.name as catName,c.description as catDesc,ib.url as imageUrl from product p,category c,imageBank ib where c.id=p.categoryid and ib.id = p.imageid and p.id=?";
					Connection conn = configur.conn;
					PreparedStatement p = conn.prepareStatement(query);
		            
					p.setInt(1,id);
					
					ResultSet rs = p.executeQuery();
					
					while(rs.next()) {
						
						Product pr = new Product();
						
						pr.setId(rs.getInt("id"));
						pr.setName(rs.getString("name"));
						pr.setDescription(rs.getString("description"));
						pr.setPrice(rs.getDouble("price"));
						pr.setImageId(rs.getInt("imageId"));
						pr.setImageUrl(rs.getString("ImageUrl"));
						pr.setCategoryid(rs.getShort("categoryid"));
						pr.setStockqty(rs.getShort("stockqty"));
						Category c = new Category();
						c.setName(rs.getString("catName"));
						c.setDescription(rs.getString("catDesc"));
					
						return pr;
					}
				}catch(Exception e) {
						e.printStackTrace();
					}
				
		return new Product();
	}
	
	}


