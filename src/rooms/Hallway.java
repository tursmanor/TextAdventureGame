package rooms;

import items.Item;
import items.nopickup.Carpet;

import java.util.ArrayList;

public class Hallway extends Room{

	public Hallway(String name, String desc) {
		super(name);
		//Description
		this.description = desc;
	
		//Add item
		items.add(new Carpet("Carpet"));
		
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", false);
		this.directions.put("east", true);
		this.directions.put("west", true);
	}

}
