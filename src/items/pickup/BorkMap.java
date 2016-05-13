package items.pickup;

import items.Item;

public class BorkMap extends Item{

	public BorkMap(String n) {
		super(n);
		this.description = " A cleverly constructed map of the BORK labyrinth that will definitely not make your parents upset.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
