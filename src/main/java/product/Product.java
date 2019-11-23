package product;

import category.Category;

public class Product {
	
	
	private int id;
	private String name;
	private String description;
	private double price;
	private short stockqty;
	private short categoryid;
	
	private Category category = new Category();
	
	private int imageId;
	
	private String ImageUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public short getStockqty() {
		return stockqty;
	}

	public void setStockqty(short stockqty) {
		this.stockqty = stockqty;
	}

	public short getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(short categoryid) {
		this.categoryid = categoryid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public Product() {
	}

	public Product(String name, String description, double price, short stockqty, short categoryid, Category category,
			int imageId, String imageUrl) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
		this.category = category;
		this.imageId = imageId;
		ImageUrl = imageUrl;
	}

	public Product(String name, String description, double price, short stockqty, short categoryid, int imageId) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
		this.imageId = imageId;
	}

	public Product(int id, String name, String description, double price, short stockqty, short categoryid,String imageUrl,
			Category category ) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
		this.ImageUrl = imageUrl;
        this.category = category;
	}

	public Product(String name, String description, double price, short stockqty, short categoryid,
			Category category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
		this.category = category;
	}

	public Product(int id, String name, String description, double price, short stockqty, short categoryid) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
	}
	

	public Product(int id, String name, String description, double price, short stockqty, short categoryid,
			int imageId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
		this.imageId = imageId;
	}

	
	public Product(int id, String name, String description, double price, short stockqty, short categoryid,
			Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockqty = stockqty;
		this.categoryid = categoryid;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stockqty=" + stockqty + ", categoryid=" + categoryid + ", category=" + category + ", imageId="
				+ imageId + ", ImageUrl=" + ImageUrl + "]";
	}
	
	

}
