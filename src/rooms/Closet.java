package rooms;

import items.pickup.*;

public class Closet extends Room {

	public Closet(String name) {
		super(name);
		//Description
		this.description = "The closet has an array of shelves stuffed with TOWELS, PILLOWS, and BEDSHEETS. You are slightly worried they will topple down any moment and engulf you. The hallway is to the SOUTH. ";
		this.changes = "CHANGES";
	
		//Adds items - can pick up
		items.add(new Bedsheet("Bedsheet"));
		items.add(new TRexPlush("T-Rex Plush"));
		
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

}
