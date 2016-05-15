package items.pickup;

import items.Item;

public class Bedsheet extends Item {

	public Bedsheet(String n) {
		super(n);
		this.description = "A pristine white bedsheet, set to meet its demise.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
