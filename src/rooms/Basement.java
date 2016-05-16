package rooms;

import items.Item;
import items.nopickup.BreakerSwitch;

public class Basement extends Room{

	public Basement(String name) {
		super(name);
		//Description
		this.description = "The basement is pitch dark. You can make out some vague \n" +
				" outlines in your peripheral vision. Your flashlight picks out a small \n" +
				"white BREAKER SWITCH in the back of the room. To the NORTH is the staircase \n" +
				"leading up to the kitchen.";
	
		//Add items
		items.add(new BreakerSwitch("Breaker Switch"));
		
		usableItems.add(items.get(0));
		
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", false);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}
	@Override 
	public void use(Item itm){
		switch(itm.getName()){
		
		case "Breaker Switch":
			System.out.println("You flip the breaker switch and the power comes back on!");
			itm.complete();
			break;
		default :
			System.out.println("You can't use that " + itm.getName());
			if(itm.canTake()){
				System.out.println("You dropped your " + itm.getName());
				items.add(itm);
			}
			break;
		}
	
	
	}
	

}
