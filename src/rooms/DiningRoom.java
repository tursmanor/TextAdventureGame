package rooms;

import items.Item;
import items.characters.Parents;
import items.nopickup.*;
import items.pickup.*;

public class DiningRoom extends Room{

	public DiningRoom(String name) {
		super(name);
		//Description
		this.description = "The dining room has a four-person wooden TABLE with \n" +
				"CHAIRS pulled up around it. There's a steaming stew in a casserole\n" +
				" dish, some salad, and a pitcher of water on the table. Your PARENTS\n" +
				" are seated on one side of the table. To the NORTH is the living room.\n" +
				" To the SOUTH is the kitchen. ";
		this.changes = "CHANGES";
	
		//Adds directions
		this.directions.put("north", true);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
		
		//Add items
		this.items.add(new Chair("Chair")); //Item 0
		this.items.add(new Parents("Parents")); //item 1
		this.items.add(new Dinner("Dinner")); //item 2
	}
	
	@Override 
	public void use(Item itm){
		switch(itm.getName()){
		case "Chair":
			itm.toggle();
			if(itm.getActivated()){
				System.out.println("You sit in the chair.");
				this.directions.put("north", false);
				this.directions.put("south", false);
			} else {
				System.out.println("You stand up and push the chair in.");
				this.directions.put("north", true);
				this.directions.put("south", true);
			}
				
			break;
		case "Dinner":
			//If you are sitting down
			if(itm.isComplete()){
				System.out.println("You already ate your dinner. You can't eat it again.");
			} else {
				if(items.get(0).getActivated() ){
					itm.complete();
					itm.hide();
					System.out.println("You eat your dinner. Nom nom nom.");
				} else {
					System.out.println("Your parents want you to eat sitting down.");
				}
			}
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
