package rooms;
import items.Item;
import items.nopickup.Computer;
import items.pickup.*;

import java.util.ArrayList;

public class YourRoom extends Room{

	public YourRoom(String name) {
		
		super(name);
		//Description
		this.description = "You share your room with your little sister. If your half of the room is a beachline, hers is the incoming tsunami. You’ve been trying to convince your parents to move her into the basement. Next to your messy SISTER’S BED is your small DESK with a COMPUTER on top of it. Your own clean BED is on the other side of the room. There is a door to the SOUTH.";
		this.changes = "CHANGES";
		
		//Add items - fixed
		items.add(new Computer("Computer")); //Item 0
				
		//Adds items - can pick up
		items.add(new FloppyDisk("BORK Floppy Disk"));
		items.add(new Flashlight("Flashlight"));
		items.add(new Pen("Pen"));
		
		
		
		
		//Adds usable items
		usableItems.add(new FloppyDisk("BORK Floppy Disk"));
		usableItems.add(new Computer("Computer"));
		
		//Adds directopms
		this.directions.put("north", false);
		this.directions.put("south", true);
		this.directions.put("east", false);
		this.directions.put("west", false);
		
	}
	
	@Override 
	public void use(Item itm){
		switch(itm.getName()){
		case "Computer":
			
				if(itm.hasContents() &&
						itm.getContentsStr().equalsIgnoreCase("BORK Floppy Disk") &&
						items.get(0).getActivated()){
					if(Room.plays > Room.events){
						System.out.println("You should deal with that before you play more BORK");
					} else {
						System.out.println("Playnig BORK...");
						Room.plays++;
					}
				} else {
					itm.toggle();
					if(itm.getActivated()){
						System.out.println("You turned the computer on.");
					} else {
						System.out.println("You turned the computer off");
					}
				}
			
			break;
		case "BORK Floppy Disk":
			Room.points++;
			items.get(0).putContents(itm);
			System.out.println("BORK disk in computer");
			break;
		default :
			System.out.println("You can't use that " + itm.getName());
			break;
		}
	
	
	}

	public void pun(){
		System.out.println("I never meta genre-aware character I didn't like... You say to yourself.");
	}
}
