package rooms;

public class ParentsRoom extends Room{

	public ParentsRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		//Description
		this.description = "Your parent’s room is decorated in shades of green. At one end of the room is their BED. You feel vaguely that you shouldn’t be in here. To the SOUTH is the hallway.";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

	
	
}
