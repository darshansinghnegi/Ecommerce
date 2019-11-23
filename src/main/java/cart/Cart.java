package cart;

public class Cart {
     private int id;
     private int productid;
     private int userid;
     private int qty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Cart() {
	}
	public Cart(int productid, int userid, int qty) {
		super();
		this.productid = productid;
		this.userid = userid;
		this.qty = qty;
	}
	public Cart(int id, int productid, int userid, int qty) {
		this.id = id;
		this.productid = productid;
		this.userid = userid;
		this.qty = qty;
	}
	public Cart(int id, int qty) {
		this.id = id;
		this.qty = qty;
	}

     
     
} 
