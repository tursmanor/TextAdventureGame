package tursmanor.adventure.items.pickup;

import tursmanor.adventure.items.Item;

public class BrontosaurusPlush extends Item{

	public BrontosaurusPlush(String n) {
		super(n);
		this.description = "A brontosaurus stuffed animal with a monocle.";
		this.canPickUp = true;
		this.hidden = true;
	}

}
