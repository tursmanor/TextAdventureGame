package rooms;

public class Bathroom extends Room{

	public Bathroom(String name) {
		super(name);
		//Description
		this.description = "The bathroom has white tile stretching up to the ceiling. There is a MIRROR above the sink, and a SHOWER to the right. To the EAST is the hallway. ";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", false);
		this.directions.put("east", true);
		this.directions.put("west", false);
	}

}
