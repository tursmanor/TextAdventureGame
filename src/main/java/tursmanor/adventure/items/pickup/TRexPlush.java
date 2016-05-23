package tursmanor.adventure.items.pickup;

import tursmanor.adventure.items.Item;

public class TRexPlush extends Item {

	public TRexPlush(String n) {
		super(n);
		this.description = "A T-rex stuffed animal with a handlebar mustache.";
		this.canPickUp = true;
		this.hidden = true;
	}

}
