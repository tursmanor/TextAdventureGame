package items.pickup;

import items.Item;

public class DirtyDishes extends Item{

	public DirtyDishes(String n) {
		super(n);
		this.description = "The remains of the day’s feasting.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
