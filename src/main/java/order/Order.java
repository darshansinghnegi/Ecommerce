package order;

public class Order {

	private int Id;
	private String Name;
	private String Proname;
	private int ProQty;
	private Float Price;
	private String Address;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProname() {
		return Proname;
	}
	public void setProname(String proname) {
		Proname = proname;
	}
	public int getProQty() {
		return ProQty;
	}
	public void setProQty(int proQty) {
		ProQty = proQty;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Order [Id=" + Id + ", Name=" + Name + ", Proname=" + Proname + ", ProQty=" + ProQty + ", Price=" + Price
				+ ", Address=" + Address + "]";
	}
	public Order(int id, String name, String proname, int proQty, Float price, String address) {
		super();
		Id = id;
		Name = name;
		Proname = proname;
		ProQty = proQty;
		Price = price;
		Address = address;
	}
	public Order(String name, String proname, int proQty, Float price, String address) {
		super();
		Name = name;
		Proname = proname;
		ProQty = proQty;
		Price = price;
		Address = address;
	}
	public Order() {
		super();
	}
	
	
	
	
	
}
