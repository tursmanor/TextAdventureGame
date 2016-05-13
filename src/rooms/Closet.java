package rooms;

public class Closet extends Room {

	public Closet(String name) {
		super(name);
		//Description
		this.description = "This is the closet";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

}
