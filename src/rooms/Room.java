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
}
