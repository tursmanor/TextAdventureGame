package rooms;

import items.Item;
import items.nopickup.Bed;
import items.nopickup.BedsheetsOnBed;
import items.pickup.TriceratopsPlush;

public class ParentsRoom extends Room{

	public ParentsRoom(String name) {
		
		super(name);
		
		//Description
		this.description = "Your parent's room is decorated in shades of green. " +
				"At one end of the room is their PARENT'S BED. You feel vaguely that you " +
				"shouldn't be in here. To the SOUTH is the hallway.";
		this.changes = "CHANGES";
	
		//Add items
		items.add(new Bed("Parent's Bed", "A large king size bed with a wooden " +
				"headboard. Underneath the bed is a TRICERATOPS PLUSH."));
		items.add(new TriceratopsPlush("Triceratops Plush"));
		items.add(new BedsheetsOnBed("Parent's Bedsheets","Your parents’ bedsheets " +
				"are always nicely made."));
		
		//Adds directions
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
	}

	// Command functions below
	@Override
		public void look(String itmName){
			for(Item itm : items){
				if(itm.getName().equalsIgnoreCase(itmName)){
					if(itm.getName().equalsIgnoreCase("Parent's Bed")){
						items.get(1).reveal();
					}
					System.out.println(itm.getDescription());
				}
			}
		}
	
}
