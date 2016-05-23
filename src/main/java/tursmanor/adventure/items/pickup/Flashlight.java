package tursmanor.adventure.items.pickup;

import tursmanor.adventure.items.Item;

public class Flashlight extends Item {

	public Flashlight(String n) {
		super(n);
		this.description = "An old battery-powered flashlight. You think it still works.";
		this.canPickUp = true;
		this.hidden = true;
	}

}
