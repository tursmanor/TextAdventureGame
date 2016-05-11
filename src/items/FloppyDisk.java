package items;

public class FloppyDisk extends Item{

	public FloppyDisk(String n) {
		super(n);
		this.description = "A floppy disk labeled \"BORK.\"";
		this.canPickUp = true;
	}

}
