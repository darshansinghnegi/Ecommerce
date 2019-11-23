package category;

public class Category {

    private short id;
    private String name;
    private String description;
    
	public short getId() {
		return id;
	}
	public void setId(short id) {
		if(id > 0 && id < 256 )
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
	public Category() {
		
	}
	public Category(String name) {
	
		this.name = name;
	}
	public Category(String name, String description) {
		
		this.name = name;
		this.description = description;
	}
	public Category(short id, String name, String description) {
		
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
    
	
    
	
}
