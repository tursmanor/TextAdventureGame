package rooms;
import items.Item;

import java.util.List;

public abstract class Room {
	
	private String name;
	protected String description;
	protected String changes;
	protected List<Item> items;
	protected boolean[] directions; //Up, right, down, left
	
	public static int points;
	public static final int MAX_POINTS = 400;
	
	public Room(String name){
		this.name = name;
	}
	
	public void printName(){
		System.out.println(name);
	}
	
	public void printDesc(){
		System.out.println(description);
	}
	
	public void printChanges(){
		System.out.println(changes);
	}
	
	public List<Item> getItems(){
		return items;
	}
	
	public boolean[] getDir(){
		return directions;
	}
	
	public void enterRoom(){
		printName();
		printDesc();
		printChanges();
		for(Item itm : items){
			if(itm.canSee())
				System.out.println("There is a " + itm.getName() + " here.");
		}
	}
	
	public boolean containsItem(String str){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(str)){ return true; }
		}
		return false;
	}
	
	public void addPoints(){
		points++;
	}
	
	public void look(String itmName){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				System.out.println(itm.getDescription());
			}
		}
	}
	
	public Item get(String itmName) throws Exception{
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				if(!itm.canSee()){
					System.out.println("You can't take that");
					return null;
				}
				items.remove(itm);
				return itm;
			}
		}
		throw new Exception("Code is broken if this happens");
	}
	
}
