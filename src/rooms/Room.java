package rooms;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Room {
	
	private String name;
	protected String description;
	protected String changes;
	protected List<Item> items;
	protected List<Item> usableItems;
	public Map<String, Boolean> directions;
	
	public static int points;
	public static final int MAX_POINTS = 400;
	public static int time;
	public static boolean saved = false;
	public Room(String name){
		this.name = name;
		this.items = new ArrayList<Item>();
		this.usableItems = new ArrayList<Item>();
		this.directions = new HashMap<String, Boolean>();
	}
	
	
	public String getName(){
		return name;
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
	
	public Item getItem(String itmName) throws Exception{
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){ return itm; }
		}
		
		throw new Exception("Item not found");
	}
	
 	
	
	public void enterRoom(){
		System.out.println(name);
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
	
	// Command functions below
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
	
	public void use(Item itm){}
	
	public void pun(){}
	
	public void talk(String itmName){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				itm.talkToItem();
			}
		}
	}
	
}
