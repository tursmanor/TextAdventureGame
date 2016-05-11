package items;

public abstract class Item {

	private String name;
	protected String description;
	protected boolean canPickUp;
	protected boolean hidden;
	
	public Item(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	

	public boolean canSee(){
		return (canPickUp && !hidden);
	}
	
	
}
