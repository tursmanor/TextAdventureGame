import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import rooms.*;
import items.*;

public class Game {
	
		
	
	public static void main(String[] args) throws Exception {
		
		Map map = new Map();
		Scanner userIn = new Scanner(System.in);
		Parser parser = new Parser("verbs.txt");
		Room.points = 0;
		Room.time = 0;
		Inventory inv = new Inventory();
		Room curRoom = map.getCurRoom();

		
		System.out.println("WELCOME.");
		System.out.println("INTRO TEXT");
		curRoom.enterRoom();
		System.out.print("> ");
		
		String[] curIn = parser.getCommand(userIn, curRoom, inv).split(" ");
		String noun = "";
		while(!curIn[0].equalsIgnoreCase("quit")){

			noun = "";
			if(curIn.length > 1){
				//Makes noun from curIn
				for(int i = 1; i < curIn.length; i++){
					noun = noun + " " + curIn[i];
				}
				noun = noun.trim();
			}
			
			// Increment timer
			Room.time++;
			
			// Look through valid commands
			switch(curIn[0]){
			
			case "inventory":
				inventory(inv);
				break;
				
			case "look":
				look(inv, curRoom, noun);
				break;
				
			case "use":
				use(inv, curRoom, noun);	
				break;
				
			case "get":
				get(inv, curRoom, noun);
				break;
				
			case "wait":
				waitTurn();
				break;
				
			case "pun":
				pun(curRoom);
				break;
				
			case "talk":
				talk(inv, curRoom, noun);
				break;
				
			case "go":
				Room newRoom = go(map, curRoom, noun);
				if(newRoom != null){
					curRoom = newRoom;
					curRoom.enterRoom();
				}
				break;
				
			case "save":
				save(curRoom);
				break;
				
			case "attack":
				attack();
				break;
				
			case "help":
				help();
				break;
				
			default:
				System.out.println("Invalid command.");
				Room.time--;
				break;
			}
			
			System.out.print("> ");
			curIn = parser.getCommand(userIn, curRoom, inv).split(" ");
			
			
		}
		System.out.println(curRoom.getName());
		
		System.out.println("THANKS FOR PLAYING, C-C-C-CHUMP.");
		System.out.println("Point total:" + Room.points + ".");
		
		// Dish out points
		if(Room.points == Room.MAX_POINTS){ 
			System.out.println("gg tryhard"); 
		} else if(Room.points == 0){
			System.out.println("brutal. savage. rekt.");
		} else {
			System.out.println("how ordinary");
		}
		
		userIn.close();
		
	}
	
	public static void waitTurn(){
		System.out.println("waiting...");
	}
	
	public static void pun(Room curRoom){
		curRoom.pun();
	}
	
	public static void talk(Inventory inv, Room curRoom, String noun){
		inv.talk(noun);
		curRoom.talk(noun);
	}
	
	public static void attack(){
		System.out.println("Violence never solves anything!!!");
	}

	public static void get(Inventory inv, Room curRoom, String noun) throws Exception{
		Item itm = curRoom.get(noun);
		if(itm != null){
			System.out.println(inv.add(itm));
			Room.points++;
		}
	}

	public static void use(Inventory inv, Room curRoom, String noun) throws Exception{
		if(inv.containsItem(noun)){
			curRoom.use(inv.useItem(noun));
		} else if (curRoom.containsItem(noun) && !curRoom.getItem(noun).canTake()){
			curRoom.use(curRoom.getItem(noun));
		} else if (curRoom.containsItem(noun) && curRoom.getItem(noun).canTake()){
			System.out.println("You should probably get that " + noun);
		} else {
			System.out.println("You don't need that " + noun);
		}
	}
	
	public static void look(Inventory inv, Room curRoom, String noun){
		if(noun.equals("")){
			curRoom.enterRoom();
		} else {
			curRoom.look(noun);
			inv.look(noun);
		}
	}

	public static void inventory(Inventory inv){
		inv.printInv();
	}

	public static void help(){
		System.out.println("Command List");
		System.out.println("Wait - wait in the current room one turn.");
		System.out.println("Pun - make a pun in the current room.");
		System.out.println("Talk <noun> - talk to <noun>");
		System.out.println("Attack <noun> - attack <noun>");
		System.out.println("Get <noun> - pick up <noun>");
		System.out.println("Use <noun> - uses <noun>");
		System.out.println("Go <direction> - travel <direction>. " +
				"Permitted directions: north, south, east, and west.");
		System.out.println("Look <noun> - look at <noun>");
		System.out.println("Inventory - prints what you are currently carrying");
		System.out.println("Save - save your current BORK game");
		System.out.println("Help - see (this) list of commands");
	}

	public static void save(Room curRoom) throws Exception{
		if(curRoom.getName().equalsIgnoreCase("Your Room")){
			if(curRoom.getItem("Computer").hasContents()){
				System.out.println("Saving your BORK game...");
				curRoom.saved = true;
			}
		} else {
			System.out.println("You can't save BORK! It isn't here.");
		}
	}

	public static Room go(Map map, Room curRoom, String direction) throws Exception{
		if(map.go(curRoom, direction)){
			return curRoom = map.getCurRoom();
			
		} else {
			return null;
		}
	}
	
	



}
