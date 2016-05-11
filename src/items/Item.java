package items;

public abstract class Item {

	private String name;
	protected String description;
	protected boolean canPickUp;
	
	public Item(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
}
