package rooms;
import items.Computer;
import items.FloppyDisk;
import items.Item;
import java.util.ArrayList;

public class YourRoom extends Room{

	public YourRoom(String name) {
		
		super(name);
		this.description = "This is your room. It's not very exciting. It has your bed, your sibling's bed, and a computer";
		this.changes = "CHANGES";
		
		this.items = new ArrayList<Item>();
		items.add(new FloppyDisk("BORK Floppy Disk"));
		items.add(new Computer("Computer"));
		
		this.directions = new boolean[] {false,false,true,false};
		
	}

}