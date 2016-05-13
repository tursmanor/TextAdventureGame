package items.pickup;

import items.Item;

public class TriceratopsPlush extends Item{

	public TriceratopsPlush(String n) {
		super(n);
		this.description = "A triceratops stuffed animal with a top hat.";
		this.canPickUp = true;
		this.hidden = true;
	}

}
