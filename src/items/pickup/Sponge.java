package items.pickup;

import items.Item;

public class Sponge extends Item{

	public Sponge(String n) {
		super(n);
		this.description = "A soft blue sponge.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
