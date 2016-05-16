package rooms;

import items.nopickup.Mirror;

public class Bathroom extends Room{

	public Bathroom(String name) {
		super(name);
		//Description
		this.description = "The bathroom has white tile stretching up to the ceiling. \n" +
				"There is a MIRROR above the sink. To the EAST is the hallway. ";
	
		//Add items
		items.add(new Mirror("Mirror"));
		
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", false);
		this.directions.put("east", true);
		this.directions.put("west", false);
	}

}
