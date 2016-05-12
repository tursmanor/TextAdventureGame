package items;

public abstract class Item {

	private String name;
	protected String description;
	protected boolean canPickUp;
	protected boolean hidden;
	protected boolean activated; 
	protected Item contents;
	
	public Item(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public boolean canTake(){
		return canPickUp;
	}
	
	public boolean canSee(){
		return (canPickUp && !hidden);
	}
	
	public void toggle(){
		activated = !activated;
	}
	
	public boolean getActivated(){
		return activated;
	}
	
	public String getContentsStr(){
		return contents.name;
	}
	
	public void putContents(Item itm){
		contents = itm;
	}
	
	public boolean hasContents(){
		return !(contents == null);
	}
}
