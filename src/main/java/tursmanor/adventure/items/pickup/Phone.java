package tursmanor.adventure.items.pickup;

import tursmanor.adventure.items.Item;

public class Phone extends Item {

	public Phone(String n) {
		super(n);
		this.description = "An old flip-phone. Good for calling people and not much else.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
