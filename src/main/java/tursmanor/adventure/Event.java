package tursmanor.adventure;

import java.util.ArrayList;
import java.util.List;

import tursmanor.adventure.items.Item;

public class Event {
	
	private List<Item> components;
	private String message;
	
	public Event (String msg){
		components = new ArrayList<Item>();
		message = "[Current Quest: " + msg + "]";
	}
	
	//Adds a requirement to the event (for setting up events)
	public void addReq (Item itm){
		components.add(itm);
	}
	
	
	//Checks if all components are in place to complete quest
	public boolean isComplete(){
		boolean counter = true;
		for(Item itm : components){
			//System.out.println("Checking item: " + itm.getName());
			counter = counter && itm.isComplete();
		}
		return counter;
	}
	
	//Prints the event message
	public void printMessage(){
		System.out.println(message);
	}
}
