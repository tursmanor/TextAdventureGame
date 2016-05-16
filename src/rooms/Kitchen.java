package rooms;
import items.pickup.Flashlight;
import items.pickup.FloppyDisk;
import items.pickup.*;

public class Kitchen extends Room {

	public Kitchen(String name) {
		super(name);
		//Description
		this.description = "The kitchen is lined with wooden cabinets. \n" +
				"There is a SINK with some DRAWERS underneath it. A wooden \n" +
				"block with KNIVES is to the right of the sink. To the NORTH \n" +
				"is the dining room. To the SOUTH is the door that leads down \n" +
				"to the basement. ";
	
		//Adds items - can pick up
		
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

		
}
