package tursmanor.adventure;

import java.util.Scanner;

import tursmanor.adventure.rooms.*;
import tursmanor.adventure.items.*;

public class Game {

	public static void main(String[] args) throws Exception {

		Map map = new Map();
		Scanner userIn = new Scanner(System.in);
		Parser parser = new Parser("verbs.txt");
		Room.points = 0;
		Room.time = 0;
		Inventory inv = new Inventory();
		Room curRoom = map.getCurRoom();
		Event[] eventArr = new Event[10];
		Event curEvent = null;
		int turnsInDark = 0;
		boolean isDark = false;
		boolean lightOn = false;
		boolean darkTriggerOnce = false;

		//Adding Events
		eventArr[0] = new Event("Your parents are calling you for dinner. \n" +
				"You should probably talk to them too.");
		eventArr[0].addReq(map.getRoom(4, 2).getItem("Dinner"));
		eventArr[0].addReq(map.getRoom(4, 2).getItem("Parents"));

		eventArr[1] = new Event("Your sister lost her three dinosaur stuffed animals and won't \n" +
				"leave you alone til you find them for her.");
		eventArr[1].addReq(map.getRoom(1, 0).getItem("Triceratops Plush"));
		eventArr[1].addReq(map.getRoom(4, 1).getItem("Brontosaurus Plush"));
		eventArr[1].addReq(map.getRoom(2, 0).getItem("T-Rex Plush"));

		eventArr[2] = new Event("You need to make a map for the BORK labyrinth. You\n " +
				"realize despairingly that you don't have paper in the house. What\n " +
				"else could you write on...?");
		eventArr[2].addReq(map.getRoom(3, 0).getItem("Pen"));
		eventArr[2].addReq(map.getRoom(2, 0).getItem("Bedsheet"));

		eventArr[3] = new Event("You need to get to turn the power back on.");
		eventArr[3].addReq(map.getRoom(4, 4).getItem("Breaker Switch"));

		//Introduction
		System.out.println("Welcome to BORK SIMULATOR 2k16. \n" +
				"Created by Zachary Segall and Eleanor Tursman in 2k16."); 
		System.out.println();
		System.out.println("Who are you? Why, you're an unabashedly nostalgic teenager. \n" +
				"And when we say nostalgic, we mean nostalgic for media that hit its peak well \n" +
				"before you were born. You are a special soul.");
		System.out.println();
		System.out.println("This afternoon, bundled along with the usual mail was your new copy \n" +
				"of BORK, the famous text-adventure game from the early 80s. Sure everyone told \n" +
				"you you could just play it for free online. Sure they gave you incredulous looks \n" +
				"when you told them that just wouldn't do. You had to own BORK yourself. And here \n" +
				"it finally was! You know what they say-- the doggo goes bork bork. And you are \n" +
				"the doggo. Time to get playing.\n");
		System.out.println("A note to the wise: Play BORK to advance the story");
		System.out.println();
		curRoom.enterRoom();
		System.out.print("> ");

		String[] curIn = parser.getCommand(userIn, curRoom, inv).split(" ");
		String noun = "";

		while(!curIn[0].equalsIgnoreCase("quit")){

			if(curEvent != null && curEvent.isComplete()){
				curEvent = null;
				Room.events++;
			}

			if(Room.plays > Room.events && Room.plays < 5){
				curEvent = eventArr[Room.events];
				curEvent.printMessage();
				System.out.println();

				if(Room.plays == 4 && !darkTriggerOnce){
					isDark = true;
					darkTriggerOnce = true;
					System.out.println("There's a BOOM and the power goes \n" +
							"out! Everything is dark.");
				}

			}

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

			if(isDark){
				System.out.println("You're stuck in the dark. You get the " +
						"feeling you may be eaten by a Bjork.");
				turnsInDark++;
				if (turnsInDark > 15){
					System.out.println("You have been eaten by a Bjork.");
					printPoints();
					userIn.close();
					return;
				}
			}

			if(Room.plays == 5){
				printWin();
				printPoints();
				userIn.close();
				return;
			}

			// Look through valid commands
			if(!isDark){
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
			} else if (isDark && !lightOn){
				switch(curIn[0]){

				case "inventory":
					inventory(inv);
					break;

				case "use":
					if(noun.equalsIgnoreCase("Phone")){
						System.out.println("Thinking quickly, you whip out your phone and use \n" +
								"the dim light of the screen to ward off the chill of the dark.\n" +
								"You can dimly see around the room. But you will need to find\n" +
								"a stronger light source to make navigate to the basement.");
						lightOn = true;
					} else if(noun.equalsIgnoreCase("flashlight")){
						System.out.println("You turn on the flashlight! It's almost like\n" +
								"the lights are on if you squint. Best get to the basement now.");
						isDark = false;
					} else {
						System.out.println("It is too dark to use that.");
					}
					break;

				case "wait":
					waitTurn();
					break;

				case "pun":
					pun(curRoom);
					break;

				case "help":
					help();
					break;

				default:
					System.out.println("It is way too dark to do that.");
					Room.time--;
					break;
				}
			} else {
				switch(curIn[0]){

				case "inventory":
					inventory(inv);
					break;

				case "look":
					look(inv, curRoom, noun);
					break;

				case "use":
					if(noun.equalsIgnoreCase("flashlight")){
						System.out.println("You turn on the flashlight! It's almost like\n" +
								"the lights are on if you squint. Best get to the basement now.");
						isDark = false;
					} else {
						System.out.println("There are more pressing things on your mind.");
					}
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

				case "help":
					help();
					break;

				default:
					System.out.println("It's still too dark for you to leave the room.");
					Room.time--;
					break;
				}
			}

			System.out.print("> ");
			curIn = parser.getCommand(userIn, curRoom, inv).split(" ");


		}
		System.out.println(curRoom.getName());
		printPoints();

		userIn.close();

	}

	/**
	 * print win text
	 */
	public static void printWin(){
		System.out.println("You lost your save data! But with the help of your trusty \n" +
				"BORK MAP, you were able to finally complete the game! You sit smugly \n" +
				"while your final score is tallied. You got a total 2047/2048 points. \n" +
				"You stare at the computer screen, unbelieving. What could possibly have \n" +
				"gone wrong? What mistake could you have made? With these thoughts wracking \n" +
				"your tired brain, you slip into an uneasy slumber...");
	}

	/**
	 * print total points
	 */
	public static void printPoints(){

		System.out.println();
		System.out.println("THANKS FOR PLAYING, C-C-C-CHUMP.");
		System.out.println("Point total:" + Room.points + ".");

		// Dish out points
		if(Room.points >= 15){ 
			System.out.println("gg tryhard"); 
		} else if(Room.points == 0){
			System.out.println("brutal. savage. rekt.");
		} else {
			System.out.println("How ordinary");
		}

	}

	/**
	 * wait one turn
	 */
	public static void waitTurn(){
		System.out.println("Waiting...");
	}

	/**
	 * make a pun, dependent on the current room
	 * @param curRoom
	 */
	public static void pun(Room curRoom){
		curRoom.pun();
	}

	/**
	 * talk to something
	 * @param inv your inventory
	 * @param curRoom the current room
	 * @param noun the current noun
	 */
	public static void talk(Inventory inv, Room curRoom, String noun){
		inv.talk(noun);
		curRoom.talk(noun);
	}

	/**
	 * attack something
	 */
	public static void attack(){
		System.out.println("Violence never solves anything!!!");
	}

	/**
	 * add something to your inventory for one point
	 * @param inv your inventory
	 * @param curRoom the current room
	 * @param noun the current noun
	 * @throws Exception
	 */
	public static void get(Inventory inv, Room curRoom, String noun) throws Exception{
		Item itm = curRoom.get(noun);
		if(itm != null){
			System.out.println(inv.add(itm));
			Room.points++;
		}
	}

	/**
	 * use an item
	 * @param inv the current inventory
	 * @param curRoom the current room
	 * @param noun the current noun
	 * @throws Exception
	 */
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

	/**
	 * look at something
	 * @param inv the current inventory
	 * @param curRoom the current room
	 * @param noun the current noun
	 */
	public static void look(Inventory inv, Room curRoom, String noun){
		if(noun.equals("")){
			curRoom.enterRoom();
		} else {
			curRoom.look(noun);
			inv.look(noun);
		}
	}

	/**
	 * print current inventory
	 * @param inv the current inventory
	 */
	public static void inventory(Inventory inv){
		inv.printInv();
	}

	/**
	 * print list of commands
	 */
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
		System.out.println("Help - see (this) list of commands");
	}

	/**
	 * move the player to a new room
	 * @param map the game map
	 * @param curRoom the current room
	 * @param direction the desired direction
	 * @return new room
	 * @throws Exception
	 */
	public static Room go(Map map, Room curRoom, String direction) throws Exception{
		if(map.go(curRoom, direction)){
			return curRoom = map.getCurRoom();

		} else {
			return null;
		}
	}





}
