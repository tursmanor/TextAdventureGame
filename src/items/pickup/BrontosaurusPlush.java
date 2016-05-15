package items.pickup;

import items.Item;

public class BrontosaurusPlush extends Item{

	public BrontosaurusPlush(String n) {
		super(n);
		this.description = "A brontosaurus stuffed animal with a monocle.";
		this.canPickUp = true;
		this.hidden = true;
	}

}
