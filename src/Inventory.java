import items.Item;

import java.util.HashMap;
import java.util.Map;


public class Inventory {

	Map<String, Item> inv;
	
	public Inventory(){
		inv = new HashMap<String, Item>();
	}
	
	public String add(Item newItem){
		inv.put(newItem.getName().toLowerCase(), newItem);	
		return "You picked up " + newItem.getName() + ".";
	}
	
	public boolean containsItem(String str){
		return inv.containsKey(str);
	}
	
	public void look(String itmName){
		if(inv.containsKey(itmName)){
			System.out.println(inv.get(itmName).getDescription());
		}
	}
	
	public void printInv(){
		for(Item itm : inv.values()){
			System.out.println(itm.getName());
		}
	}
	
}
