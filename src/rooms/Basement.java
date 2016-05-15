package rooms;

public class Basement extends Room{

	public Basement(String name) {
		super(name);
		//Description
		this.description = "The basement is pitch dark. You can make out some vague outlines in your peripheral vision. Your flashlight picks out a small white BREAKER BOX in the back of the room. To the NORTH is the staircase leading up to the kitchen.";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", false);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

}
