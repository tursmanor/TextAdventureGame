package items.characters;

import items.Item;

public class Person extends Item {

	public Person(String n) {
		super(n);
		this.canPickUp = false;
		this.hidden = false;
	}

}
