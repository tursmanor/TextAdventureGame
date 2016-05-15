package rooms;

import items.Item;
import items.nopickup.Pillows;
import items.nopickup.Towels;
import items.pickup.*;

public class Closet extends Room {

	public Closet(String name) {
		super(name);
		//Description
		this.description = "The closet has an array of shelves stuffed with TOWELS, PILLOWS, " +
				"and BEDSHEETS. You are slightly worried they will topple down any moment and " +
				"engulf you. The hallway is to the SOUTH.";
		this.changes = "CHANGES";
	
		//Adds items - can pick up
		items.add(new Towels("Towels"));
		items.add(new Pillows("Pillows"));
		items.add(new TRexPlush("T-Rex Plush"));
		items.add(new Bedsheet("Bedsheet"));
		
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}
	
	@Override
	public void look(String itmName){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				if(itm.getName().equalsIgnoreCase("Towels")){
					items.get(2).reveal();
				}
				System.out.println(itm.getDescription());
			}
		}
	}

}
