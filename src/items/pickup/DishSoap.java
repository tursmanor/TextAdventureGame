package items.pickup;

import items.Item;

public class DishSoap extends Item{

	public DishSoap(String n) {
		super(n);
		this.description = "Sudsy green dish soap.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
