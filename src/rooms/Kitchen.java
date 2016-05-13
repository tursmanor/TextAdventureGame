package rooms;

public class Kitchen extends Room {

	public Kitchen(String name) {
		super(name);
		//Description
		this.description = "This is the kitchen";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

		
}
