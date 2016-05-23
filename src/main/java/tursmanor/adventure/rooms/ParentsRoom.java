package tursmanor.adventure.rooms;

import tursmanor.adventure.items.Item;
import tursmanor.adventure.items.nopickup.Bed;
import tursmanor.adventure.items.nopickup.BedsheetsOnBed;
import tursmanor.adventure.items.pickup.TriceratopsPlush;

public class ParentsRoom extends Room{

	public ParentsRoom(String name) {
		
		super(name);
		
		//Description
		this.description = "Your parent's room is decorated in shades of green. \n" +
				"At one end of the room is their PARENT'S BED. You feel vaguely that you \n" +
				"shouldn't be in here. To the SOUTH is the hallway.";
	
		//Add items
		items.add(new Bed("Parent's Bed", "A large king size bed with a wooden \n" +
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

	/**
	 * reveal the triceratops plush if the player looks at the bed
	 */
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
