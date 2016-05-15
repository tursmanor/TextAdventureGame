package items.characters;

public class Parents extends Person{

	public Parents(String n) {
		super(n);
		this.description = ("Your loving parents who just want you to sit down and have a nice conversation.");
	}
	
	@Override
	public void talkToItem(){
		System.out.println("You talk to your parents while thinking about playing BORK");
		this.completed = true;
	}
}
