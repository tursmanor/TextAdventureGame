package rooms;
import items.Computer;
import items.FloppyDisk;
import items.Item;
import java.util.ArrayList;

public class YourRoom extends Room{

	public YourRoom(String name) {
		
		super(name);
		//Description
		this.description = "This is your room. It's not very exciting. " +
				"It has your bed, your sibling's bed, and a computer";
		this.changes = "CHANGES";
		
		//Adds items
		items.add(new FloppyDisk("BORK Floppy Disk"));
		items.add(new Computer("Computer"));
		
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
				System.out.println("Playnig BORK...");
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
