package items.pickup;

import items.Item;

public class Flashlight extends Item {

	public Flashlight(String n) {
		super(n);
		this.description = "An old battery-powered flashlight. You think it still works.";
		this.canPickUp = true;
		this.hidden = true;
	}

}
