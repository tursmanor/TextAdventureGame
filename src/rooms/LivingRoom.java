package rooms;

import items.pickup.Flashlight;
import items.pickup.FloppyDisk;
import items.pickup.*;

public class LivingRoom extends Room{

	public LivingRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		//Description
		this.description = "This is the living room";
		this.changes = "CHANGES";
		
		//Adds items - can pick up
		items.add(new BrontosaurusPlush("Brontosaurus Plush"));
		
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", true);
	}

}
