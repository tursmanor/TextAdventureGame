package tursmanor.adventure.items.pickup;

import tursmanor.adventure.items.Item;

public class Pen extends Item{

	public Pen(String n) {
		super(n);
		this.description = "Pen: A cheap pen with teeth marks lining the cap.";
		this.canPickUp = true;
		this.hidden = false;
	}

}
