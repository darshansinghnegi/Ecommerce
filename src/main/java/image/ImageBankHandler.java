package image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.core.Config;

import config.configur;

interface ImageBankStandard{
	void insert(ImageBank ib);
	String update(ImageBank ib);
	
	String deleteById(int id);
	
	List<ImageBank>fetchAllImagesInBank();
}

public class ImageBankHandler implements ImageBankStandard{

	public void insert(ImageBank ib) {
		
		try {
			String query ="insert into imagebank "+"(url)"+"values"+"(?)";
			
            Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, ib.getUrl());
			
			p.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<ImageBank> fetchAllImagesInBank() {
        List<ImageBank> list =new ArrayList<ImageBank>();
		try {
			String query ="select * from imagebank";
			
			 Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				list.add(new ImageBank(rs.getInt("id"),rs.getString("url")));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String deleteById(int id) {
		
		try {
					
					String query = "delete from imagebank where id=?";
					Connection conn = configur.conn;
					PreparedStatement p = conn.prepareStatement(query);
		            
					p.setInt(1,id);
					
					p.executeUpdate();
					
							
					
				}catch(Exception e) {
						e.printStackTrace();
						return e.getMessage();
					}
		return "Image Bank Deletion SuccessFully";
	}

	public String update(ImageBank ib) {
		try {
			String query = "update imagebank set url=? where id=?";
			Connection conn = configur.conn;
			PreparedStatement p = conn.prepareStatement(query);
            
		    p.setString(1, ib.getUrl());
			p.setInt(2,ib.getId());
			
			p.executeUpdate();
			
		}catch(Exception e) {
			return e.getMessage();
		}
		return "Image Updated SuccessFully";
	
		}
	}

	

