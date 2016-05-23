package tursmanor.adventure.items.characters;

public class Sister extends Person{

	public Sister(String n) {
		super(n);
		this.description = "The devil incarnate smiles at you.";
	}

	@Override
	public void talkToItem(){
		System.out.println("You make smalltalk with your sister while thinking \n" +
				" about playing BORK.");
		this.completed = true;
	}
}
