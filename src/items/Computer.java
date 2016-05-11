package items;

public class Computer extends Item{

	public Computer(String n) {
		super(n);
		this.description = "Your computer.";
		this.canPickUp = false;
	}

}
