package items;

public class Computer extends Item{

	public Computer(String n) {
		super(n);
		this.description = "Your computer.";
		this.canPickUp = false;
		this.hidden = false;
		this.activated = false;
		this.contents = null;
	}
	
	@Override
	public void talkToItem(){
		System.out.println("You tell your computer you love it. It doesn't respond.");
	}

}
