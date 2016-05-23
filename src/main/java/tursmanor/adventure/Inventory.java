package tursmanor.adventure;

import items.Item;
import items.*;
import items.pickup.*;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

	public Map<String, Item> inv;
	
	public Inventory(){
		inv = new HashMap<String, Item>();
		inv.put("Phone", new Phone("Phone"));
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
	
	public void talk(String itmName){
		if(inv.containsKey(itmName)){
			inv.get(itmName).talkToItem();
		}
	}
	
	public void printInv(){
		for(Item itm : inv.values()){
			System.out.println(itm.getName());
		}
	}
	
	public Item useItem(String itmName){
		Item temp = inv.get(itmName);
		inv.remove(itmName);
		return temp;
	}
}
