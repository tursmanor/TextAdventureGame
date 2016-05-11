import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import rooms.*;
import items.*;

public class Game {
	
	public static void main(String[] args) throws Exception {

		Scanner userIn = new Scanner(System.in);
		Parser parser = new Parser("verbs.txt");
		Room.points = 0;
		Inventory inv = new Inventory();

		System.out.println("WELCOME.");
		System.out.println("INTRO TEXT");
		Room curRoom = new YourRoom("Your Room");
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
			
			switch(curIn[0]){
			case "inventory":
				inv.printInv();
				break;
			case "look":
				if(noun.equals("")){
					curRoom.enterRoom();
				} else {
					curRoom.look(noun);
					inv.look(noun);
				}
				break;
			case "use":
				System.out.println("use");
				break;
			case "get":
				Item itm = curRoom.get(noun);
				if(itm != null){
					System.out.println(inv.add(itm));
					Room.points++;
				}
				break;
			case "wait":
				System.out.println("wait");
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}
			
			System.out.print("> ");
			curIn = parser.getCommand(userIn, curRoom, inv).split(" ");
			
			
		}
		
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

}
