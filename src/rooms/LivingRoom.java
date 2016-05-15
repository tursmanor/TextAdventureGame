package rooms;
import items.Item;
import items.nopickup.*;
import items.pickup.*;

public class LivingRoom extends Room{

	public LivingRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		//Description
		this.description = "The comfotrable living room has a red COUCH " +
				"that is great for sitting on when watching the TV. Since " +
				"it's dark out, the CURTAINS have been drawn across the " +
				"windows. To the WEST is the staircase leading to the " +
				"second-floor hallway. To the SOUTH is the dining room. ";
		this.changes = "CHANGES";
		
		//Adds items - can pick up
		items.add(new Couch("Couch"));
		items.add(new TV("TV"));
		items.add(new Cushions("Cushions"));
		items.add(new Curtains("Curtains"));
		items.add(new BrontosaurusPlush("Brontosaurus Plush"));
		
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", true);
	}
	
	@Override
		public void look(String itmName){
			for(Item itm : items){
				if(itm.getName().equalsIgnoreCase(itmName)){
					if(itm.getName().equalsIgnoreCase("Cushions")){
						items.get(4).reveal();
					}
					System.out.println(itm.getDescription());
				}
			}
		}
	
	
}
