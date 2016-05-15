package items.pickup;

import items.Item;

public class FloppyDisk extends Item{

	public FloppyDisk(String n) {
		super(n);
		this.description = "A floppy disk labeled \"BORK.\"";
		this.canPickUp = true;
		this.hidden = false;
		this.activated = false;
		this.contents = null;
	}

	@Override
	public void talkToItem(){
		System.out.println("You tell your floppy disk it is old. You hurt its feelings.");
	}

}
