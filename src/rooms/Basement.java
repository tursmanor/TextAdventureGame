package rooms;

import items.nopickup.BreakerBox;
import items.nopickup.BreakerSwitch;

public class Basement extends Room{

	public Basement(String name) {
		super(name);
		//Description
		this.description = "The basement is pitch dark. You can make out some vague \n" +
				" outlines in your peripheral vision. Your flashlight picks out a small \n" +
				"white BREAKER BOX in the back of the room. To the NORTH is the staircase \n" +
				"leading up to the kitchen.";
	
		//Add items
		items.add(new BreakerBox("Breaker Box"));
		items.add(new BreakerSwitch("Breaker Switch"));
		
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", false);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

}
