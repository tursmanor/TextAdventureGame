package rooms;

public class DiningRoom extends Room{

	public DiningRoom(String name) {
		super(name);
		//Description
		this.description = "This is the dining room";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

}
