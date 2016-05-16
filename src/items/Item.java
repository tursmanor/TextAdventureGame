package items;

public abstract class Item {

	private String name;
	protected String description;
	protected boolean canPickUp;
	protected boolean hidden;
	protected boolean activated; 
	protected boolean completed;
	protected Item contents;
	
	public Item(String n){
		name = n;
		completed = false;
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
	
	public void hide (){
		hidden = true;
	}
	
	public void reveal (){
		hidden = false;
	}
	
	public boolean canSee(){
		return (canPickUp && !hidden);
	}
	
	public void complete(){
		completed = true;
	}
	
	public boolean isComplete(){
		return completed;
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
	
	public void talkToItem(){
		System.out.println("Look at you, talking to inanimate objects.");
	}
}
