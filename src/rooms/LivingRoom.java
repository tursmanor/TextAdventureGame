package rooms;

public class LivingRoom extends Room{

	public LivingRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		//Description
		this.description = "This is the living room";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", true);
	}

}
