package rooms;
import items.pickup.Flashlight;
import items.pickup.FloppyDisk;
import items.pickup.*;

public class Kitchen extends Room {

	public Kitchen(String name) {
		super(name);
		//Description
		this.description = "This is the kitchen";
		this.changes = "CHANGES";
	
		//Adds items - can pick up
		items.add(new DishSoap("Dish Soap"));
		items.add(new Sponge("Sponge"));
		items.add(new DirtyDishes("Dirty Dishes"));
		
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

		
}
