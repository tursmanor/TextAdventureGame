package rooms;

public class ParentsRoom extends Room{

	public ParentsRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		//Description
		this.description = "This is your parent's room";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

	
	
}
