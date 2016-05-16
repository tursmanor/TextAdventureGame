package items.nopickup;

import items.Item;

public class FixedItem extends Item{

	public FixedItem(String n) {
		super(n);
		this.canPickUp = false;
		this.hidden = false;
	}


}
