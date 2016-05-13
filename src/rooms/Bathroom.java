package rooms;

public class Bathroom extends Room{

	public Bathroom(String name) {
		super(name);
		//Description
		this.description = "This is the bathroom";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", false);
		this.directions.put("east", true);
		this.directions.put("west", false);
	}

}
