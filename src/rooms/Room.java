package rooms;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Room {
	
	private String name;
	protected String description;
	protected List<Item> items;
	protected List<Item> usableItems;
	public Map<String, Boolean> directions;
	
	public static int points;
	public static int time;
	public static int plays = 0;
	public static int events = 0;
	
	public Room(String name){
		this.name = name;
		this.items = new ArrayList<Item>();
		this.usableItems = new ArrayList<Item>();
		this.directions = new HashMap<String, Boolean>();
	}
	
	/**
	 * getter for name
	 * @return name string
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * prints room description
	 */
	public void printDesc(){
		System.out.println(description);
	}
	
	/**
	 * gets list of items in room
	 * @return list of items 
	 */
	public List<Item> getItems(){
		return items;
	}
	
	/**
	 * gets an item in the room using the item name
	 * @param itmName name of the item
	 * @return item object
	 * @throws Exception if the item isn't found
	 */
	public Item getItem(String itmName) throws Exception{
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){ return itm; }
		}
		
		throw new Exception("Item not found");
	}
	
	/**
	 * print necessary text when player enters a new room
	 */
	public void enterRoom(){
		System.out.println(name.toUpperCase());
		System.out.println();
		printDesc();
		for(Item itm : items){
			if(itm.canSee()){
				System.out.println("There is a " + itm.getName() + " here.");
			}
		}
	}
	
	/**
	 * Check if the room contains the given item, given the item's name 
	 * @param str the name of the item
	 * @return true or false
	 */
	public boolean containsItem(String str){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(str)){ return true; }
		}
		return false;
	}
	
	/**
	 * increment point counter
	 */
	public void addPoints(){
		points++;
	}
	
	// Command functions below
	
	/**
	 * prints the item's description if it is in the room
	 * @param itmName the item's name
	 */
	public void look(String itmName){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				System.out.println(itm.getDescription());
			}
		}
	}
	
	/**
	 * if the item in the room is visible, remove it from the room and return it
	 * @param itmName the name of the item
	 * @return the item object
	 * @throws Exception we should never see this because the parser shouldn't accept invalid nouns
	 */
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
	
	/**
	 * use an item
	 * @param itm an item
	 */
	public void use(Item itm){
		if(itm.canTake()){
			System.out.println("You dropped your " + itm.getName());
			items.add(itm);
		}
	}
	
	/**
	 * make a pun
	 */
	public void pun(){
		System.out.println("Punfortunately we ran out of time for coming up with more puns.");
	}
	
	/** 
	 * talk to an item
	 * @param itmName the item name
	 */
	public void talk(String itmName){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				itm.talkToItem();
			}
		}
	}
	
}
