package items;

public class FloppyDisk extends Item{

	public FloppyDisk(String n) {
		super(n);
		this.description = "A floppy disk labeled \"BORK.\"";
		this.canPickUp = true;
		this.hidden = false;
		this.activated = false;
		this.contents = null;
	}

}
