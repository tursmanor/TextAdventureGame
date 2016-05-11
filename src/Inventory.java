import items.Item;

import java.util.HashMap;
import java.util.Map;


public class Inventory {

	Map<String, Item> inv;
	
	public Inventory(){
		inv = new HashMap<String, Item>();
	}
	
	public String add(Item newItem){
		inv.put(newItem.getName(), newItem);	
		return "You picked up " + newItem.getName() + ".";
	}
	
	public boolean containsItem(String str){
		return inv.containsKey(str);
	}
	
}
