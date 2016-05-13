package rooms;

public class Basement extends Room{

	public Basement(String name) {
		super(name);
		//Description
		this.description = "This is the basement";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", false);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

}
