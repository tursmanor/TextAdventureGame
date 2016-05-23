package tursmanor.adventure.rooms;

import tursmanor.adventure.items.Item;
import tursmanor.adventure.items.characters.Sister;
import tursmanor.adventure.items.nopickup.Bed;
import tursmanor.adventure.items.nopickup.Computer;
import tursmanor.adventure.items.nopickup.Desk;
import tursmanor.adventure.items.nopickup.DeskDrawer;
import tursmanor.adventure.items.pickup.*;

import java.util.ArrayList;

public class YourRoom extends Room{

	public YourRoom(String name) {
		
		super(name);
		//Description
		this.description = "You share your room with your little sister. If \n" +
				"your half of the room is a beachline, hers is the incoming \n" +
				"tsunami. You've been trying to convince your parents to move \n" +
				"her into the basement. Next to your messy sister's bed is your\n" +
				"small DESK with a COMPUTER on top of it. Your SISTER is sitting\n" +
				"on her bed. Your own clean BED is on the other side of the room.\n" +
				"There is a door to the SOUTH.";
		
		//Add items 
		items.add(new Computer("Computer")); //Item 0
		items.add(new Flashlight("Flashlight"));
		items.add(new Sister("Sister"));
		items.add(new Desk("Desk"));
		items.add(new DeskDrawer("Desk Drawer"));
		
		//Adds items - can pick up
		items.add(new FloppyDisk("BORK Floppy Disk"));
		items.add(new Pen("Pen"));
		items.add(new Bed("Bed","A well-made twin bed with a green comforter."));
		
		//Adds usable items
		usableItems.add(new FloppyDisk("BORK Floppy Disk"));
		usableItems.add(new Computer("Computer"));
		
		//Adds directions
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
						System.out.println("Playing BORK...");
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
			
		case "Triceratops Plush":
		case "T-Rex Plush":
		case "Brontosaurus Plush":
			System.out.println("You sister is pleased you retreived \n" +
								"one of her stuffed animals.");
			itm.complete();
			break;
			
		case "Bedsheet":
			items.add(2, itm);
			System.out.println("You spread the bedsheet on your table");
			itm.complete();
			break;
			
		case "Pen":
			if(items.get(2).getName().equalsIgnoreCase("Bedsheet")){
				itm.complete();
				System.out.println("You diagram a map on the bedsheet and hope your parents won't be mad.");
				items.add(new BorkMap("BORK map"));
				items.remove(2);
			} else {
				items.add(itm);
				System.out.println("There's nothing to write on here. You drop the pen in despair.");
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

	@Override
	public void look(String itmName){
		for(Item itm : items){
			if(itm.getName().equalsIgnoreCase(itmName)){
				if(itm.getName().equalsIgnoreCase("Desk Drawer")){
					items.get(1).reveal();
				}
				System.out.println(itm.getDescription());
			}
		}
	}

	public void pun(){
		System.out.println("I never meta genre-aware character I didn't like... You say to yourself.");
	}
}
